package com.lucidchart.pekko.threadcontext

import org.apache.pekko.dispatch.DispatcherPrerequisites
import com.github.threadcontext.Context
import com.typesafe.config.Config

class DefaultDispatcherConfigurator(config: Config, prerequisites: DispatcherPrerequisites)
  extends DispatcherConfigurator(config, prerequisites, Context.DEFAULT)
