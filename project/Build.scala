object Build extends sbt.Build {

  override val buildLoaders = PomResolverPlugin.buildLoaders

}
