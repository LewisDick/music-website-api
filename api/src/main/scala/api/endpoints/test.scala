package api.endpoints

import sttp.tapir._
import sttp.tapir.server.http4s._
import cats.effect.IO
import org.http4s.HttpRoutes
import cats.effect._
import cats.implicits._

import scala.concurrent.ExecutionContext

object TestRoutes {
  implicit val ec: ExecutionContext = scala.concurrent.ExecutionContext.Implicits.global
  implicit val contextShift: ContextShift[IO] = IO.contextShift(ec)
  implicit val timer: Timer[IO] = IO.timer(ec)

  val testEndpoint: Endpoint[Unit, Unit, String, Nothing] = endpoint.get.in("test").out(stringBody)

  val testRoutes: HttpRoutes[IO] = testEndpoint.toRoutes(_ => IO("lmao".asRight[Unit]))
}
