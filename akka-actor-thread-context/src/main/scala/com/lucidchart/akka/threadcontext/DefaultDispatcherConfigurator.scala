package com.lucidchart.akka.threadcontext

import akka.dispatch.DispatcherPrerequisites
import com.github.threadcontext.Context
import com.typesafe.config.Config

class DefaultDispatcherConfigurator(config: Config, prerequisites: DispatcherPrerequisites)
  extends DispatcherConfigurator(config, prerequisites, Context.DEFAULT)
