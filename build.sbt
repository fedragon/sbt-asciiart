import Defaults._

sbtPlugin := true

organization := "com.github.fedragon"

name := "sbt-asciiart"

description := "Helps spotting the last command in your SBT output"

homepage := Some(url("https://github.com/fedragon/sbt-asciiart"))

publishMavenStyle := true

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (version.value.trim.endsWith("SNAPSHOT")) Some(
    "snapshots" at nexus + "content/repositories/snapshots"
  )
  else Some("releases" at nexus + "service/local/staging/deploy/maven2")
}

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

pomExtra := (
  <licenses>
    <license>
      <name>MIT</name>
      <url>https://github.com/fedragon/sbt-asciiart/blob/master/LICENSE</url>
    </license>
  </licenses>
  <scm>
    <connection>scm:git:github.com/fedragon/sbt-asciiart</connection>
    <developerConnection>scm:git:git@github.com:fedragon/sbt-asciiart</developerConnection>
    <url>github.com/fedragon/sbt-asciiart</url>
  </scm>
  <developers>
    <developer>
      <id>fedragon</id>
      <name>Federico Ragona</name>
    </developer>
  </developers>
)
