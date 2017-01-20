lazy val `opentracing-globaltracer` = externalPomProject(
  "io.opentracing.contrib" % "opentracing-globaltracer" % "0.1.0-SNAPSHOT",
  uri("git://github.com/opentracing-contrib/java-globaltracer.git#223ac98d")
)

lazy val `opentracing-spanmanager` = externalPomProject(
  "io.opentracing.contrib" % "opentracing-spanmanager" % "0.0.1",
  uri("git://github.com/opentracing-contrib/java-activespan.git#23885b8a")
)

lazy val `akka-actor-spanmanager` = project.dependsOn(`opentracing-globaltracer`, `opentracing-spanmanager`).cross

lazy val `akka-actor-spanmanager_2.11` = `akka-actor-spanmanager`("2.11.8").copy(base = file("akka-actor-spanmanager"))

lazy val `akka-actor-spanmanager_2.12` = `akka-actor-spanmanager`("2.12.1").copy(base = file("akka-actor-spanmanager"))

lazy val `akka-actor-spanmanager-aggregate` = `akka-actor-spanmanager`.aggregate(`akka-actor-spanmanager_2.11`, `akka-actor-spanmanager_2.12`)

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
