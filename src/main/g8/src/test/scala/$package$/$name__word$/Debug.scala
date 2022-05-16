package $package$.$name;format="word"$

$if(http.truthy)$
import io.gatling.http.Predef._
$endif$
import io.gatling.core.Predef._
$if(amqpPlugin.truthy)$
import ru.tinkoff.gatling.amqp.Predef._
$endif$
import ru.tinkoff.gatling.config.SimulationConfig._
$if(kafkaPlugin.truthy)$
import ru.tinkoff.gatling.kafka.Predef._
$endif$
$if(jdbcPlugin.truthy)$
import ru.tinkoff.load.jdbc.Predef._
$endif$
import $package$.$name;format="word"$.scenarios._

class Debug extends Simulation {

  // proxy is required on localhost:8888

  setUp(
    $if(http.truthy)$
    HttpScenario().inject(atOnceUsers(1)),
    $endif$
    $if(jdbcPlugin.truthy)$
    JdbcScenario().inject(atOnceUsers(1)),
    $endif$
    $if(amqpPlugin.truthy)$
    AmqpScenario().inject(atOnceUsers(1)),
    $endif$
    $if(amqpPlugin.truthy)$
    KafkaScenario().inject(atOnceUsers(1)),
    $endif$
  ).protocols(
    $if(http.truthy)$httpProtocol,$endif$
    $if(jdbcPlugin.truthy)$jdbcProtocol,$endif$
    $if(amqpPlugin.truthy)$amqpProtocol,$endif$
    $if(kafkaPlugin.truthy)$kafkaProtocol,$endif$
    $if(http.truthy)$
    //        .proxy(Proxy("localhost", 8888).httpsPort(8888))
    $endif$
  ).maxDuration(testDuration)

}
