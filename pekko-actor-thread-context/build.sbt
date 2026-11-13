libraryDependencies ++= Seq(
  "org.apache.pekko" %% "pekko-actor" % "1.0.2",
  "com.lucidchart" % "thread-context" % "0.7",
  "org.scalatest" %% "scalatest-funsuite" % "3.2.17" % Test
)
publishTo := sonatypePublishToBundle.value
