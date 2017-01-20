# OpenTracing for Akka Actors

This currently lacks much of what you would expect to find for Akka Actors.

## SpanManager support

`ManagedSpan`s can be propogated in local actor systems with `SpanManagerExecutorConfigurator`.

Replace

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
