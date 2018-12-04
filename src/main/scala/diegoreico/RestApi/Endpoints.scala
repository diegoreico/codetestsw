package diegoreico.RestApi

import com.typesafe.config.{Config, ConfigFactory}
import akka.http.scaladsl.model.{ContentTypes, HttpEntity}
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route


class Endpoints(configuration :Config, presenter : Presenter) {

  val rootRooter: Route =
    path(configuration.getString("api.version")) {
      get {
        pathEndOrSingleSlash {
          complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, "<h1>Hello from the Code Test</h1>"))
        }
      }
    }

  val decodeRouter: Route =
    pathPrefix(configuration.getString("api.version")) {
      path(configuration.getString("api.endpoints.decode")) {
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
