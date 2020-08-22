package api

import cats.effect.{ContextShift, IO, Timer}
import org.http4s.server.Router
import api.endpoints.TestRoutes
import scala.concurrent.ExecutionContext
import org.http4s.server.blaze.BlazeServerBuilder
import org.http4s.syntax.kleisli._

object Main extends App {
  implicit val ec: ExecutionContext = scala.concurrent.ExecutionContext.Implicits.global
  implicit val contextShift: ContextShift[IO] = IO.contextShift(ec)
  implicit val timer: Timer[IO] = IO.timer(ec)

  BlazeServerBuilder[IO](ec)
    .bindHttp(8080, "localhost")
    .withHttpApp(Router("/" -> TestRoutes.testRoutes).orNotFound)
    .resource
    .use { _ =>
      IO {
        println("Go to: http://localhost:8080")
        println("Press any key to exit ...")
        scala.io.StdIn.readLine()
      }
    }
    .unsafeRunSync()
}
