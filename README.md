# OpenTracing for Akka Actors

This currently lacks much of what you would expect to find for Akka Actors.

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
