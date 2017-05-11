resolvers ++= Seq(
  "Sonatype OSS Releases" at "https://oss.sonatype.org/content/repositories/releases/"
)

addSbtPlugin("com.github.gseitz" % "sbt-release" % "1.0.5")
