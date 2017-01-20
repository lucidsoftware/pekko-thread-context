package io.opentracing.contrib.akka.actor

import akka.dispatch.DispatcherPrerequisites
import com.typesafe.config.Config
import io.opentracing.contrib.spanmanager.DefaultSpanManager

class DefaultSpanManagerExecutorConfigurator(config: Config, prerequisites: DispatcherPrerequisites) extends AbstractSpanManagerExecutorConfigurator(config, prerequisites) {
  protected[this] def spanManager = DefaultSpanManager.getInstance
}
