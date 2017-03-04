# OpenTracing for Akka Actors

[![Build Status](https://travis-ci.org/lucidsoftware/akka-context.svg?branch=master)](https://travis-ci.org/lucidsoftware/akka-context)
![Maven Version](https://img.shields.io/maven-central/v/com.lucidchart/akka-actor-context_2.11.svg)

This currently lacks much of what you would expect to find for Akka Actors.

## Install

```scala
libraryDependencies += "com.lucidchart" %% "akka-context" % "<version>"
```

## Usage

In configuration,

```hocon
actor.default-dispatcher.type = com.lucidchart.akka.context.DispatchConfigurator
```
