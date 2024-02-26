lazy val `pekko-actor-thread-context` = project.cross

lazy val commonSettings = Seq(publishTo := sonatypePublishToBundle.value)

lazy val `pekko-actor-thread-context_2.12` = `pekko-actor-thread-context`("2.12.14").settings(commonSettings)
lazy val `pekko-actor-thread-context_2.13` = `pekko-actor-thread-context`("2.13.12").settings(commonSettings)

inScope(Global)(Seq(
  credentials += Credentials("Sonatype Nexus Repository Manager", "oss.sonatype.org", sys.env.getOrElse("SONATYPE_USERNAME", ""), sys.env.getOrElse("SONATYPE_PASSWORD", "")),
  developers += Developer("pauldraper", "Paul Draper", "paulddraper@gmail.com", url("https://github.com/pauldraper")),
  homepage := Some(url("https://git.lucidchart.com/lucidsoftware/pekko-thread-context")),
  licenses += "Apache 2.0 License" -> url("https://www.apache.org/licenses/LICENSE-2.0"),
  organization := "com.lucidchart",
  organizationHomepage := Some(url("http://github.com/lucidsoftware")),
  organizationName := "Lucid Software",
  resolvers += Resolver.typesafeRepo("releases"),
  scalaVersion := "2.13.12",
  scmInfo := Some(ScmInfo(
    url("https://github.com/lucidsoftware/pekko-thread-context"),
    "scm:git:git@github.com:lucidsoftware/pekko-thread-context.git"
  )),
  startYear := Some(2017),
  publishMavenStyle := true,
  version := sys.props.getOrElse("build.version", "0-SNAPSHOT")
))

publish / skip := true
