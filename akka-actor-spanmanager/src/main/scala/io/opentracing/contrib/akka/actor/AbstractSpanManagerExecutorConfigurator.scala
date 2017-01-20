package io.opentracing.contrib.akka.actor

import akka.dispatch._
import com.typesafe.config.Config
import io.opentracing.contrib.spanmanager.SpanManager
import io.opentracing.contrib.spanmanager.concurrent.SpanPropagatingExecutorService
import java.util.concurrent.ThreadFactory

abstract class AbstractSpanManagerExecutorConfigurator(config: Config, prerequisites: DispatcherPrerequisites) extends ExecutorServiceConfigurator(config, prerequisites) {
  import AbstractSpanManagerExecutorConfigurator._

  private[this] val delegate = {
    val unwrappedConfig = config.withValue("executor", config.getValue(DelegateExecutorKey))
    // It doesn't seem like MessageDispatcherConfigurator was meant for this, but it works
    val dispatcherConfigurator = new MessageDispatcherConfigurator(unwrappedConfig, prerequisites) {
      def dispatcher() = throw new UnsupportedOperationException
    }
    dispatcherConfigurator.configureExecutor()
  }

  protected[this] def spanManager: SpanManager

  def createExecutorServiceFactory(id: String, threadFactory: ThreadFactory) = new ExecutorServiceFactory {
    private[this] val delegate = AbstractSpanManagerExecutorConfigurator.this.delegate.createExecutorServiceFactory(id, threadFactory)
    def createExecutorService = new SpanPropagatingExecutorService(delegate.createExecutorService, spanManager)
  }
}

object AbstractSpanManagerExecutorConfigurator {
  def DelegateExecutorKey = "delegate-executor"
}
