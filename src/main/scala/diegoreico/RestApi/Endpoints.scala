package diegoreico.RestApi

import com.typesafe.config.{Config, ConfigFactory}
import akka.http.scaladsl.model.{ContentTypes, HttpEntity}
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route


class Endpoints(presenter : Presenter) {

  val Configuration: Config = ConfigFactory.load("application.conf")

  val rootRooter: Route =
    path(Configuration.getString("api.version")) {
      get {
        pathEndOrSingleSlash {
          complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, "<h1>Hello to the Stratio Wars Code Test</h1>"))
        }
      }
    }

  val decodeRouter: Route =
    pathPrefix(Configuration.getString("api.version")) {
      path(Configuration.getString("api.endpoints.decode")) {
        get {
          parameters('values) { values =>
            val results = presenter.decodeCoordinates(values)
            complete(HttpEntity(ContentTypes.`application/json`, results))
          }

        }
      }
    }

  val routes: Route = decodeRouter ~ rootRooter
}
