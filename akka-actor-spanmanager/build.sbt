description := "Opentracing ThreadLocal support for Akka"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.4.16",
  "io.opentracing" % "opentracing-api" % "0.20.7"
)

moduleName := s"opentracing-${name.value}"
