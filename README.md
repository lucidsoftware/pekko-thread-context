# Pekko actor thread context

[![Build Status](https://travis-ci.com/lucidsoftware/pekko-thread-context.svg?branch=main)](https://travis-ci.com/lucidsoftware/pekko-thread-context)
![Maven Version](https://img.shields.io/maven-central/v/com.lucidchart/pekko-actor-thread-context_2.13.svg)

Propagate thread-local values across Pekko actors. See
[java-thread-context](https://github.com/lucidsoftware/java-thread-context).

Currently works only for local actor systems.

Supports Scala 2.12.21, 2.13.18, and 3.3.9 (the default), with Pekko 1.2.1.

## Build and test

Using JDK 25, package and test both supported Scala versions:

```sh
sbt +package
sbt +test
```

Use `sbt package` or `sbt test` to build only the default Scala version.
Cross-built jars are written to `target/out/jvm/scala-*/pekko-actor-thread-context/`.

## Install

```scala
libraryDependencies += "com.lucidchart" %% "pekko-actor-thread-context" % "<version>"
```

## Usage

In the configuration for your actor system,

```hocon
actor.default-dispatcher.type = com.lucidchart.pekko.threadcontext.DefaultDispatcherConfigurator
```

## Publishing

Publishing uses sbt's native Sonatype Central Portal support and sbt-pgp.
Set `SONATYPE_USERNAME` and `SONATYPE_PASSWORD` to a Central Portal user token's
username and password in CI. Snapshot publishing must be enabled for the namespace.
`publish.sh` signs and publishes both Scala variants with `+publishSigned`, then
runs `sonaRelease` once for tagged releases.
