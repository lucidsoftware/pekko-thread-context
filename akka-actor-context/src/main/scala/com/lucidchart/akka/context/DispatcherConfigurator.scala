package com.lucidchart.akka.context

import akka.dispatch.{Dispatcher, DispatcherPrerequisites, MessageDispatcherConfigurator}
import com.lucidchart.threadcontext.ContextManager
import com.typesafe.config.Config
import java.util.concurrent.TimeUnit
import scala.concurrent.duration.DurationLong

class DispatcherConfigurator(config: Config, prerequisites: DispatcherPrerequisites) extends MessageDispatcherConfigurator(config, prerequisites) {
  override val dispatcher = new Dispatcher(
    this,
    config.getString("id"),
    config.getInt("throughput"),
    config.getDuration("throughput-deadline-time", TimeUnit.NANOSECONDS).nanos,
    configureExecutor(),
    config.getDuration("shutdown-timeout", TimeUnit.MILLISECONDS).millis
  ) { dispatcher =>
    override def execute(runnable: Runnable) = super.execute(ContextManager.runnable(runnable))
  }
}
