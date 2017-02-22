name := """lazy-cyclist"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

libraryDependencies += "org.scalaj" % "scalaj-http_2.11" % "2.3.0"
libraryDependencies += "org.json4s" % "json4s-native_2.11" % "3.4.0"
libraryDependencies += "org.scalatest" % "scalatest_2.11" % "2.2.6" % "test"

scalaVersion := "2.11.7"
