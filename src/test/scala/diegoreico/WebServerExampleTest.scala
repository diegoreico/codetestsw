package diegoreico

import org.scalatest.{ Matchers, WordSpec }
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.testkit.ScalatestRouteTest
import akka.http.scaladsl.server._
import Directives._

class WebServerExampleTest extends WordSpec with Matchers with ScalatestRouteTest {

  "The service" should {

    "return a greeting for GET requests to the root path" in {
      // tests:
      Get("/v1") ~> Endpoints.routes ~> check {
        responseAs[String] shouldEqual "<h1>Hello to the Stratio Wars Code Test</h1>"
      }
    }

    "leave GET requests to other paths unhandled" in {
      // tests:
      Get("/kermit") ~> Endpoints.routes ~> check {
        handled shouldBe false
      }
    }

    "return a MethodNotAllowed error for PUT requests to the root path" in {
      // tests:
      Put("/v1") ~> Route.seal(Endpoints.routes) ~> check {
        status shouldEqual StatusCodes.MethodNotAllowed
        responseAs[String] shouldEqual "HTTP method not allowed, supported methods: GET"
      }
    }
  }
}
