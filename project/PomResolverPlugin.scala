import sbt.BuildLoader.ResolveInfo
import sbt._

object PomResolverPlugin extends AutoPlugin {

  val Scheme = "pom"

  object autoImport {
    def externalPomProject(module: ModuleID, uri: URI) = RootProject(new URI(Scheme, s"$module:$uri", null))
  }

  override val trigger = allRequirements

  val buildLoaders = Seq(BuildLoader.resolve { resolveInfo =>
    if (resolveInfo.uri.getScheme == Scheme) {
      val Array(organization, name, version, wrapped) = resolveInfo.uri.getSchemeSpecificPart.split(":", 4)
      val wrappedInfo = new ResolveInfo(new URI(wrapped), resolveInfo.staging, resolveInfo.config, resolveInfo.state)
      RetrieveUnit(wrappedInfo).map { fn => () => {
        val file = fn()
        IO.write(file / "build.sbt",
          s"""externalPom()
            |
            |crossPaths := false
            |
            |ivyConfigurations += config("default")
            |
            |name := "$name"
            |
            |organization := "$organization"
            |
            |version := "$version"
          """.stripMargin)
        file
      }}
    } else {
      None
    }
  })

}
