package diegoreico.RestApi

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import com.typesafe.config.{Config, ConfigFactory}

import scala.concurrent.ExecutionContextExecutor
import scala.io.StdIn

object WebServer extends App {
  override def main(args: Array[String]): Unit = {
    val configuration: Config = ConfigFactory.load("application.conf")

    implicit val system: ActorSystem = ActorSystem("my-system")
    implicit val materializer: ActorMaterializer = ActorMaterializer()
    // needed for the future flatMap/onComplete in the end
    implicit val executionContext: ExecutionContextExecutor = system.dispatcher

    val host = configuration.getString("host")
    val port = configuration.getInt("port")
    val version = configuration.getString("api.version")

    val presenter = new DefaultPresenter()
    val endpoints = new Endpoints(configuration, presenter)

    val bindingFuture = Http().bindAndHandle(endpoints.routes, host, port)

    println(s"Server online at http://$host:$port/$version\nPress RETURN to stop...")
    StdIn.readLine() // let it run until user presses return
    bindingFuture
      .flatMap(_.unbind()) // trigger unbinding from the port
      .onComplete(_ => system.terminate()) // and shutdown when done
  }
}
