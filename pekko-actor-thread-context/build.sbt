libraryDependencies ++= Seq(
  "org.apache.pekko" %% "pekko-actor" % "1.2.1",
  "com.lucidchart" % "thread-context" % "0.8"
)
publishTo := {
  if (isSnapshot.value)
    Some("central-snapshots" at "https://central.sonatype.com/repository/maven-snapshots/")
  else localStaging.value
}
