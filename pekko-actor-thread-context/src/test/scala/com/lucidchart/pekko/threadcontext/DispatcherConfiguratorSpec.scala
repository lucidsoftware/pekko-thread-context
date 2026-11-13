package com.lucidchart.pekko.threadcontext

import com.github.threadcontext.{Context, ThreadLocalContextSupplier}
import com.typesafe.config.ConfigFactory
import java.util.concurrent.{CountDownLatch, TimeUnit}
import org.apache.pekko.actor.ActorSystem
import org.scalatest.funsuite.AnyFunSuite
import scala.concurrent.{Await, Promise}
import scala.concurrent.duration._

class DispatcherConfiguratorSpec extends AnyFunSuite {
  test("the default dispatcher captures context at submission and isolates successive tasks") {
    val threadLocal = new ThreadLocal[String]()
    val supplier = new ThreadLocalContextSupplier(threadLocal)
    Context.DEFAULT.suppliers.add(supplier)
    val started = new CountDownLatch(1)
    val release = new CountDownLatch(1)
    val system = ActorSystem("thread-context-test", ConfigFactory.parseString("""
      pekko.actor.default-dispatcher {
        type = "com.lucidchart.pekko.threadcontext.DefaultDispatcherConfigurator"
        executor = "thread-pool-executor"
        thread-pool-executor.fixed-pool-size = 1
      }
    """))

    try {
      val first = Promise[String]()
      threadLocal.set("first-request")
      system.dispatcher.execute(() => {
        started.countDown()
        if (release.await(10, TimeUnit.SECONDS)) {
          first.success(threadLocal.get())
        } else {
          first.failure(new IllegalStateException("Timed out waiting to release the dispatcher"))
        }
      })
      assert(started.await(10, TimeUnit.SECONDS))

      val second = Promise[String]()
      threadLocal.set("second-request")
      system.dispatcher.execute(() => { second.success(threadLocal.get()); () })

      val empty = Promise[String]()
      threadLocal.remove()
      system.dispatcher.execute(() => { empty.success(threadLocal.get()); () })
      release.countDown()

      assert(Await.result(first.future, 10.seconds) == "first-request")
      assert(Await.result(second.future, 10.seconds) == "second-request")
      assert(Await.result(empty.future, 10.seconds) == null)
      assert(threadLocal.get() == null)
    } finally {
      release.countDown()
      threadLocal.remove()
      try Await.result(system.terminate(), 10.seconds)
      finally Context.DEFAULT.suppliers.remove(supplier)
    }
  }
}
