# Pekko actor thread context

[![Build Status](https://travis-ci.com/lucidsoftware/pekko-thread-context.svg?branch=master)](https://travis-ci.com/lucidsoftware/pekko-thread-context)
![Maven Version](https://img.shields.io/maven-central/v/com.lucidchart/pekko-actor-thread-context_2.13.svg)

Propagate thread-local values across Pekko actors. See
[java-thread-context](https://github.com/lucidsoftware/java-thread-context).

Currently works only for local actor systems.

Cross-built for Scala 2.12, 2.13, and 3.

## Install

```scala
libraryDependencies += "com.lucidchart" %% "pekko-actor-thread-context" % "<version>"
```

## Usage

In the configuration for your actor system,

```hocon
actor.default-dispatcher.type = com.lucidchart.pekko.threadcontext.DefaultDispatcherConfigurator
```
