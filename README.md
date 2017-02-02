# OpenTracing for Akka Actors

[![Build Status](https://travis-ci.org/lucidsoftware/opentracing-akka-actor.svg?branch=master)](https://travis-ci.org/lucidsoftware/opentracing-akka-actor)
![Maven Version](https://img.shields.io/maven-central/v/com.lucidchart/opentracing-akka-actor_2.11.svg)

This currently lacks much of what you would expect to find for Akka Actors.

## Install

```scala
libraryDependencies += "com.lucidchart" %% "opentracing-akka-actor" % "<version>"
```

## SpanManager support

`ManagedSpan`s can be propogated in local actor systems with `DefaultSpanManagerExecutorConfigurator`.

In configuration, replace

```hocon
actor {
    default-dispatcher {
        executor = fork-join-executor
        fork-join-executor {
            parallelism-factor = 2
        }
    }
}
```

with

```hocon
actor {
    default-dispatcher {
        executor = io.opentracing.contrib.akka.actor.DefaultSpanManagerExecutorConfigurator
        delegate-executor = fork-join-executor
        fork-join-executor {
            parallelism-factor = 2
        }
    }
}
```
