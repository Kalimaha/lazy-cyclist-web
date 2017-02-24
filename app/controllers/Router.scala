package controllers

import core.Core
import parsers.EEPParser
import play.api.mvc._
import repositories.{DirectionsRepository, ElevationRepository}

object Router extends Controller {
  def route(from: String, to: String) = Action {
    val dr: DirectionsRepository = new DirectionsRepository(directionsAPIKey())
    val er: ElevationRepository  = new ElevationRepository(elevationAPIKey())

    val profiles = Core.elevationProfile(from, to, dr, er)

    profiles match {
      case Left(message)  => InternalServerError(message)
      case Right(_)       => Ok(EEPParser.toJSON(profiles.right.get)).enableCors
    }
  }

//  def directionsAPIKey(): String = sys.env("DIRECTIONS_API_KEY")
//  def elevationAPIKey(): String  = sys.env("ELEVATION_API_KEY")

  def directionsAPIKey(): String = "AIzaSyDawUXHj6EEm9rdF52YGX102C9GTRyVZJs"
  def elevationAPIKey(): String  = "AIzaSyDpqJYbyoCqtjZymDLC2mann1sJUzYObkI"

  implicit class RichResult (result: Result) {
    def enableCors =  result.withHeaders(
      "Access-Control-Allow-Origin"       -> "*",
      "Access-Control-Allow-Methods"      -> "OPTIONS, GET, POST, PUT, DELETE, HEAD",
      "Access-Control-Allow-Headers"      -> "Accept, Content-Type, Origin, X-Json, X-Prototype-Version, X-Requested-With",
      "Access-Control-Allow-Credentials"  -> "true"
    )
  }
}