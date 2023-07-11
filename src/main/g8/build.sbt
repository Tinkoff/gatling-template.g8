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
    $if(amqpPlugin.truthy) $
      libraryDependencies ++= amqpPlugin,
    $endif$
      $if (kafkaPlugin.truthy) $
      libraryDependencies ++= kafkaPlugin,
    libraryDependencies ++= kafkaSerializer,
    libraryDependencies ++= avro4s,
    $endif$
      $if (jdbcPlugin.truthy) $
      libraryDependencies ++= jdbcPlugin,
    libraryDependencies ++= postgresJdbc,
    $endif$
      scalacOptions ++= Seq (
        "-encoding",
        "UTF-8",
        "-Xfatal-warnings",
        "-deprecation",
        "-feature",
        "-unchecked",
        "-language:implicitConversions",
        "-language:higherKinds",
        "-language:existentials",
        "-language:postfixOps"
      ),
  )
