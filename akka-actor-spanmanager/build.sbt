crossScalaVersions := Seq("2.10.6", "2.11.8")

description := "Opentracing ThreadLocal support for Akka"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.4.12",
  "io.opentracing" % "opentracing-api" % "0.20.7"
)

moduleName := s"opentracing-${name.value}"
