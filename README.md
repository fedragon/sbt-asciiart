# sbt-asciiart

ASCII art. In your SBT console. Can you imagine the possibilites?

## Example

```
> compile

           (    )
            (oo)   wow
   )\.-----/(O O)
  # ;       / u        so ascii
    (  .   |} )
     |/ `.;|/;   much art
     "     " "

[info] Compiling 2 Scala sources to ~/.../sbt-asciiart/target/...
```

## Installation

Add the following lines to your local (`project/plugins.sbt`) or global (`~/.sbt/0.13/plugins/plugins.sbt`) configuration:

    resolvers ++= Seq(
        "Sonatype OSS Releases" at "https://oss.sonatype.org/content/repositories/releases/"
    )

    addSbtPlugin("com.github.fedragon" % "sbt-asciiart" % "1.0.0")

## Usage

    sbt asciiArt

## Customization

    asciiArt::color  := scala.Console.BLUE
    asciiArt::art    := "@@@@@@@@@@@ -_- @@@@@@@@@@@"

## Hook to existing tasks

### Globally

Run

    echo "import com.github.fedragon.asciiart.AsciiArtPlugin._" > ~/.sbt/0.13/plugins/sbt-asciiart.sbt

and then any of (or all) the lines described below, depending on your wishes.

### For a single project

Add the following line to that project's `build.sbt`:

    import AsciiArtPlugin._

and then any (or all) the lines described below, depending on your needs.

### How to execute it when compiling source files

    asciiArtWhenCompiling

### How to hook it to any other task

    asciiArtWhen(<your task>, <its configuration>)

The above example is just an alias for:

    asciiArtWhen(compile, Compile)
    // = the `compile` task in the `Compile` configuration
