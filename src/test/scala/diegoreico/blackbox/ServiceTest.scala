package diegoreico.blackbox

import diegoreico.Endpoints
import org.scalatest.{Matchers, WordSpec}
import akka.http.scaladsl.testkit.ScalatestRouteTest


class ServiceTest extends WordSpec with Matchers with ScalatestRouteTest {

  "The service" should {
    "return the decode string to a provided encrypted coordinates" in {
      // tests:
      Get("/v1/decode?values=6f9c15fa-ef51-4415-afab-36218d76c2d9") ~> Endpoints.routes ~> check {
        responseAs[String] shouldEqual "73-15-46-dc9876321"
      }
    }
  }
}
