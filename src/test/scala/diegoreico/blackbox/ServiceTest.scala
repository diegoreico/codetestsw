package diegoreico.blackbox

import diegoreico.Endpoints
import org.scalatest.{Matchers, WordSpec}
import akka.http.scaladsl.testkit.ScalatestRouteTest


class ServiceTest extends WordSpec with Matchers with ScalatestRouteTest {

  "The service" should {
    "should return the decode string to a provided encrypted coordinates" in {
      // tests:
      Get("/v1/decode?values=2952410b-0a94-446b-8bcb-448dc6e30b08") ~> Endpoints.routes ~> check {
        responseAs[String] shouldEqual "22-10-42-edcb86430"
      }
    }
  }
}
