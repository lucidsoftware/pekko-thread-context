# Akka actor thread context

[![Build Status](https://travis-ci.com/lucidsoftware/akka-thread-context.svg?branch=master)](https://travis-ci.com/lucidsoftware/akka-thread-context)
![Maven Version](https://img.shields.io/maven-central/v/com.lucidchart/akka-actor-thread-context_2.11.svg)

Propagate thread-local values across Akka actors. See
[java-thread-context](https://github.com/lucidsoftware/java-thread-context).

Currently works only for local actor systems.

## Install

```scala
libraryDependencies += "com.lucidchart" %% "akka-actor-thread-context" % "<version>"
```

## Usage

In the configuration for your actor system,

```hocon
actor.default-dispatcher.type = com.lucidchart.akka.threadcontext.DefaultDispatcherConfigurator
```
