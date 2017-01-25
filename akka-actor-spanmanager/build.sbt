description := "Opentracing ThreadLocal support for Akka"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.4.16",
  "io.opentracing" % "opentracing-api" % "0.20.7",
  "io.opentracing.contrib" % "opentracing-globaltracer" % "0.1.0",
  "io.opentracing.contrib" % "opentracing-spanmanager" % "0.0.1"
)

moduleName := s"opentracing-${name.value}"
