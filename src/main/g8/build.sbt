import Dependencies._

enablePlugins(GatlingPlugin)

lazy val root = (project in file("."))
  .settings(
    inThisBuild(
      List(
        organization := "$package$",
        scalaVersion := "$scala_version$",
        version      := "0.1.0",
      ),
    ),
    name := "$name$",
    libraryDependencies ++= gatling,
    libraryDependencies ++= gelf,
    libraryDependencies ++= gatlingPicatinny,
    libraryDependencies ++= janino,
    scalacOptions ++= Seq(
      "-encoding",
      "UTF-8",
      "-Xfatal-warnings",
      "-deprecation",
      "-feature",
      "-unchecked",
      "-language:implicitConversions",
      "-language:higherKinds",
      "-language:existentials",
      "-language:postfixOps",
    ),
  )
