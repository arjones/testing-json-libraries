import sbt._
import sbt.Keys._

object TestingJsonLibrariesBuild extends Build {

  lazy val testingJsonLibraries = Project(
    id = "testing-json-libraries",
    base = file("."),
    settings = Project.defaultSettings ++ Seq(
      name := "Testing JSON libraries",
      organization := "io.smx",
      version := buildVersion,

      scalaVersion := "2.9.2",
      scalacOptions := Seq("-deprecation", "-encoding", "utf8"),

      libraryDependencies ++= libDeps,
      resolvers ++= extResolvers,

      initialCommands := "import io.smx._"
      // add other settings here
    )
  )

  lazy val buildVersion = {
    val f = new File("VERSION");
    if (!f.exists) "0.1-SNAPSHOT"; else scala.io.Source.fromFile(f).mkString.trim
  }

  lazy val libDeps = Seq[ModuleID](
    // "joda-time" % "joda-time" % "2.2",
    // "org.joda" % "joda-convert" % "1.3.1"
    "io.backchat.jerkson" %% "jerkson" % "0.7.0",
    "io.spray" %% "spray-json" % "1.2.3" cross CrossVersion.full,
    //    "org.slf4j" % "slf4j-api" % "1.6.6",
    //    "play" %% "play" % "2.1-09142012",
    "org.scalatest" %% "scalatest" % "1.9.1" % "test"

  )

  lazy val extResolvers = Seq[MavenRepository](
    "spray" at "http://repo.spray.io/"
    //    "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"
    // "Twitter Public Maven Repo" at "http://maven.twttr.com/",
    // "Concurrent Maven Repo" at "http://conjars.org/repo"
  )

}
