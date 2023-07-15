package $package$

import io.gatling.core.Predef._
import io.gatling.http.Predef._
$if(kafkaPlugin.truthy) $
import org.apache.kafka.clients.producer.ProducerConfig
$endif$
$if(amqpPlugin.truthy) $
import ru.tinkoff.gatling.amqp.Predef._
import ru.tinkoff.gatling.amqp.protocol.AmqpProtocolBuilder
$endif$
import ru.tinkoff.gatling.config.SimulationConfig._
$if(kafkaPlugin.truthy) $
import ru.tinkoff.gatling.kafka.Predef.kafka
import ru.tinkoff.gatling.kafka.protocol.KafkaProtocolBuilder
$endif$
$if(jdbcPlugin.truthy) $
import ru.tinkoff.load.jdbc.Predef._
import ru.tinkoff.load.jdbc.protocol.JdbcProtocolBuilder

import scala.concurrent.duration.DurationInt
$endif$

package object $name;
format = "word" $ {

  $if(http.truthy) $
  // common http protocol params (eg headers, checks)
  val httpProtocol = http
    .baseUrl(
      baseUrl,
    )                                                                                // Here is the root for all relative URLs, located in simulation.conf file, or -DbaseUrl="" passed to test param
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8") // Here are the common headers
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0")
    .disableFollowRedirect
  $endif$

  $if(jdbcPlugin.truthy) $
  val jdbcProtocol: JdbcProtocolBuilder = DB
    .url(getStringParam("dbUrl"))
    .username(getStringParam("dbUser"))
    .password(getStringParam("dbPassword"))
    .connectionTimeout(2.minute)
  $endif$

  $if(amqpPlugin.truthy) $
  val amqpHost: String     = getStringParam("amqpHost")
  val amqpPort: Int        = getIntParam("amqpPort")
  val amqpLogin: String    = getStringParam("amqpLogin")
  val amqpPassword: String = getStringParam("amqpPassword")

  val amqpProtocol: AmqpProtocolBuilder   = amqp
    .connectionFactory(
      rabbitmq
        .host(amqpHost)
        .port(amqpPort)
        .username(amqpLogin)
        .password(amqpPassword)
        .vhost("/"),
    )
    .replyTimeout(60000)
    .consumerThreadsCount(8)
    .usePersistentDeliveryMode
  $endif$
  $if(kafkaPlugin.truthy) $
  val kafkaProtocol: KafkaProtocolBuilder = kafka
    .topic("myTopic")
    .properties(
      Map(
        ProducerConfig.ACKS_CONFIG                   -> "1",
        ProducerConfig.BOOTSTRAP_SERVERS_CONFIG      -> getStringParam("kafkaUrl"),
        ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG   -> "org.apache.kafka.common.serialization.StringSerializer",
        ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG -> "org.apache.kafka.common.serialization.StringSerializer",
      ),
    )
  $endif$
}
