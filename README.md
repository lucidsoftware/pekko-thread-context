# Akka actor thread context

[![Build Status](https://travis-ci.org/lucidsoftware/akka-context.svg?branch=master)](https://travis-ci.org/lucidsoftware/akka-context)
![Maven Version](https://img.shields.io/maven-central/v/com.lucidchart/akka-actor-context_2.11.svg)

Propagate thread-local values across Akka actors. See
[java-thread-context](https://github.com/lucidsoftware/java-thread-context).

Currently works only for local actor systems.

## Install

```scala
libraryDependencies += "com.lucidchart" %% "akka-context" % "<version>"
```

## Usage

In configuration,

```hocon
actor.default-dispatcher.type = com.lucidchart.akka.threadcontext.DispatchConfigurator
```
