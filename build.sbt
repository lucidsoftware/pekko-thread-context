lazy val `akka-actor-spanmanager` = project.cross

lazy val `akka-actor-spanmanager_2.11` = `akka-actor-spanmanager`("2.11.8")
lazy val `akka-actor-spanmanager_2.12` = `akka-actor-spanmanager`("2.12.1")

inScope(Global)(Seq(
  credentials += Credentials("Sonatype Nexus Repository Manager", "oss.sonatype.org", sys.env.getOrElse("SONATYPE_USERNAME", ""), sys.env.getOrElse("SONATYPE_PASSWORD", "")),
  developers += Developer("pauldraper", "Paul Draper", "paulddraper@gmail.com", url("https://github.com/pauldraper")),
  licenses += "Apache 2.0 License" -> url("https://www.apache.org/licenses/LICENSE-2.0"),
  organization := "com.lucidchart",
  organizationHomepage := Some(url("http://opentracing.io/")),
  organizationName := "OpenTracing",
  PgpKeys.pgpPassphrase := Some(Array.emptyCharArray),
  resolvers += Resolver.typesafeRepo("releases"),
  scalaVersion := "2.11.8",
  scmInfo := Some(ScmInfo(
    url("https://github.com/lucidsoftware/opentracing-akka-actor"),
    "scm:git:git@github.com:lucidsoftware/opentracing-akka-actor.git"
  )),
  startYear := Some(2017),
  version := "0.0-SNAPSHOT"
))
