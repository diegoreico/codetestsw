package diegoreico.blackbox

import org.scalatest.{Matchers, WordSpec}
import akka.http.scaladsl.testkit.ScalatestRouteTest
import diegoreico.RestApi.Endpoints


class ServiceTest extends WordSpec with Matchers with ScalatestRouteTest {

  "The service" should {
    "return the decoded string to single provided encrypted coordinates" in {
      // tests:
      Get("/v1/decode?values=6f9c15fa-ef51-4415-afab-36218d76c2d9") ~> Endpoints.routes ~> check {
        responseAs[String] shouldEqual "[73-15-46-dc9876321]"
      }
    }
    "return the decode string to multiple provided encrypted coordinates" in {
      Get("/v1/decode?values=6f9c15fa-ef51-4415-afab-36218d76c2d9,2ab81c9b-1719-400c-a676-bdba976150eb") ~> Endpoints.routes ~> check {
        responseAs[String] shouldEqual "[73-15-46-dc9876321,64-9-35-edba976510]"
      }
    }
  }
}
