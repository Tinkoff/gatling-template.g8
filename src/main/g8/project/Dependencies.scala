import sbt._

object Dependencies {
  lazy val gatling: Seq[ModuleID] = Seq(
    "io.gatling.highcharts" % "gatling-charts-highcharts",
    "io.gatling"            % "gatling-test-framework",
  ).map(_ % "$gatling_version$" % Test)

  lazy val gelf: Seq[ModuleID]             = Seq("de.siegmar" % "logback-gelf" % "4.0.2")
  lazy val gatlingPicatinny: Seq[ModuleID] = Seq("ru.tinkoff" %% "gatling-picatinny" % "$gatling_picatinny_version$")
  lazy val janino: Seq[ModuleID]           = Seq("org.codehaus.janino" % "janino" % "3.1.8")
  $if(amqpPlugin.truthy) $
  lazy val amqpPlugin: Seq[ModuleID]       = Seq("ru.tinkoff" %% "gatling-amqp-plugin" % "0.8.0")
  $endif$
  $if(kafkaPlugin.truthy) $
  lazy val kafkaPlugin: Seq[ModuleID]      = Seq("ru.tinkoff" %% "gatling-kafka-plugin" % "0.9.0")
  lazy val kafkaSerializer: Seq[ModuleID]  = Seq("io.confluent" % "kafka-avro-serializer" % "5.3.0")
  lazy val avro4s: Seq[ModuleID]           = Seq("com.sksamuel.avro4s" %% "avro4s-core" % "4.0.4")
  $endif$
  $if(jdbcPlugin.truthy) $
  lazy val jdbcPlugin: Seq[ModuleID]       = Seq("ru.tinkoff" %% "gatling-jdbc-plugin" % "0.7.0")
  lazy val postgresJdbc: Seq[ModuleID]     = Seq("org.postgresql" % "postgresql" % "42.3.3")
  $endif$
}
