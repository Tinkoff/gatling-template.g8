// This build is for this Giter8 template.
// To test the template run `g8` or `g8Test` from the sbt session.
// See http://www.foundweekends.org/giter8/testing.html#Using+the+Giter8Plugin for more details.
lazy val root = (project in file("."))
  .enablePlugins(SbtPlugin)
  .settings(
    name        := "template-gatling.g8",
    Test / test := {
      val _ = (Test / g8Test).toTask("").value
    },
    scalacOptions ++= Seq(
      "-encoding",
      "utf8", // Option and arguments on same line
      "-deprecation",
      "-unchecked",
      "-language:implicitConversions",
      "-language:higherKinds",
      "-language:existentials",
      "-language:postfixOps",
    ),
  )
