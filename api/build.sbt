name := "api"

version := "0.1"

scalaVersion := "2.13.3"

libraryDependencies ++= Seq(
  "org.http4s" %% "http4s-core"         % "0.21.7",
  "org.http4s" %% "http4s-blaze-server" % "0.21.7",
  "org.http4s" %% "http4s-blaze-client" % "0.21.7",
  "org.http4s" %% "http4s-circe"        % "0.21.7",
  "org.http4s" %% "http4s-dsl"          % "0.21.7",
  "com.softwaremill.sttp.tapir" %% "tapir-core" % "0.16.15",
  "com.softwaremill.sttp.tapir" %% "tapir-http4s-server" % "0.16.15",
  "org.typelevel" %% "cats-core" % "2.1.1",
  "org.typelevel" %% "cats-effect" % "2.1.4"
)
