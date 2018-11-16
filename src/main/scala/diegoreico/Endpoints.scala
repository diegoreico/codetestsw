package diegoreico

import akka.http.scaladsl.model.{ContentTypes, HttpEntity}
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import diegoreico.Decoder

import diegoreico.WebServer.Configuration

object Endpoints {

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
            val results = values.split(",")
              .map(EncryptedCoordinates(_))
              .map(Decoder.decode)
                .reduce((r1,r2) => r1 + ',' + r2 )
            complete(HttpEntity(ContentTypes.`application/json`, s"[${results}]"))
          }

        }
      }
    }

  val routes: Route = decodeRouter ~ rootRooter
}
