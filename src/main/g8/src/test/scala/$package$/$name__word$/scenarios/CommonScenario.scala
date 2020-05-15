package $package$.$name;format="word"$.scenarios

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import $package$.$name;format="word"$.cases._

object CommonScenario {
  def apply(): ScenarioBuilder = new CommonScenario().scn
}

class CommonScenario {

  val scn: ScenarioBuilder = scenario("Common Scenario")
  .exec(GetMainPage.getMainPage)

}