package com.lucidchart.pekko.threadcontext

import org.apache.pekko.dispatch.{Dispatcher, DispatcherPrerequisites, MessageDispatcherConfigurator}
import com.github.threadcontext.Context
import com.typesafe.config.Config
import java.util.concurrent.TimeUnit
import java.util.function.Supplier
import scala.concurrent.duration.DurationLong

class DispatcherConfigurator(config: Config, prerequisites: DispatcherPrerequisites, contextSupplier: Supplier[Context]) extends MessageDispatcherConfigurator(config, prerequisites) {
  private val configuredDispatcher = new Dispatcher(
    this,
    config.getString("id"),
    config.getInt("throughput"),
    config.getDuration("throughput-deadline-time", TimeUnit.NANOSECONDS).nanos,
    configureExecutor(),
    config.getDuration("shutdown-timeout", TimeUnit.MILLISECONDS).millis
  ) { dispatcher =>
    override def execute(runnable: Runnable): Unit = {
      val context = contextSupplier.get()
      super.execute(() => context.run(runnable))
    }
  }

  override def dispatcher(): Dispatcher = configuredDispatcher
}
