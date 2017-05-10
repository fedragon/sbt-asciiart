package com.github.fedragon.asciiart

import sbt._, Keys._

object AsciiArtPlugin extends AutoPlugin {

  object autoImport {
    lazy val asciiArt = taskKey[Unit]("Prints my ASCII art to console")
    lazy val art = settingKey[String]("Set my ASCII art")
    lazy val color = settingKey[String]("Set my ASCII art color")
  }

  import autoImport._

  override def trigger = allRequirements

  override lazy val projectSettings = Seq(
    art in asciiArt := AsciiArt.DefaultArt,
    color in asciiArt := AsciiArt.DefaultColor,
    asciiArt := AsciiArt(
      (art in asciiArt).value,
      (color in asciiArt).value)
  )

  def asciiArtWhen[T](t: TaskKey[T], c: Configuration): Seq[Def.Setting[_]] =
    inConfig(c)((t in c) := ((t in c).dependsOn(asciiArt)).value)

  val asciiArtWhenCompiling: Seq[Def.Setting[_]] =
    asciiArtWhen(compile, Compile)

  val asciiArtWhenTesting: Seq[Def.Setting[_]] =
    asciiArtWhen(test, Test)
}

object AsciiArt {
  import scala.Console.{YELLOW, RESET}

  val DefaultColor = YELLOW
  val DefaultArt = """
           (    )
            (oo)   wow
   )\.-----/(O O)
  # ;       / u        so ascii
    (  .   |} )
     |/ `.;|/;   much art
     "     " "
"""

  def apply(header: String, color: String): Unit = println(s"$color$header$RESET")
}
