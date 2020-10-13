import sbt._

object Dependencies {
  lazy val gatling: Seq[ModuleID] = Seq(
    "io.gatling.highcharts" % "gatling-charts-highcharts",
    "io.gatling"            % "gatling-test-framework"
  ).map(_ % "$gatling_version$" % Test)

  lazy val gelf: Seq[ModuleID] = Seq(
    "de.siegmar" % "logback-gelf"
  ).map(_ % "2.1.0")

  lazy val gatlingPicatinny: Seq[ModuleID] = Seq(
    "ru.tinkoff" %% "gatling-picatinny"
  ).map(_ % "$gatling_picatinny_version$")

  lazy val janino: Seq[ModuleID] = Seq(
    "org.codehaus.janino" % "janino"
  ).map(_ % "3.1.2")

}
