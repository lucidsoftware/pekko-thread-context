lazy val root = (project in file("."))
  .aggregate(`pekko-actor-thread-context`)
  .settings(
    publish / skip := true,
    crossScalaVersions := Nil
  )

lazy val `pekko-actor-thread-context` = (project in file("pekko-actor-thread-context"))
  .settings(crossScalaVersions := Seq("2.12.21", "2.13.18", "3.3.9"))

inScope(Global)(Seq(
  developers += Developer("pauldraper", "Paul Draper", "paulddraper@gmail.com", uri("https://github.com/pauldraper")),
  homepage := Some(uri("https://git.lucidchart.com/lucidsoftware/pekko-thread-context")),
  licenses += "Apache 2.0 License" -> uri("https://www.apache.org/licenses/LICENSE-2.0"),
  organization := "com.lucidchart",
  organizationHomepage := Some(uri("http://github.com/lucidsoftware")),
  organizationName := "Lucid Software",
  resolvers += Resolver.typesafeRepo("releases"),
  scalaVersion := "3.3.9",
  scmInfo := Some(ScmInfo(
    uri("https://github.com/lucidsoftware/pekko-thread-context"),
    "scm:git:git@github.com:lucidsoftware/pekko-thread-context.git"
  )),
  startYear := Some(2017),
  publishMavenStyle := true,
  version := sys.props.getOrElse("build.version", "0-SNAPSHOT")
))
