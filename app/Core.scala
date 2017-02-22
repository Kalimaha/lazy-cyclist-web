import models.Models._
import parsers.DirectionsParser._
import parsers.ElevationParser._
import repositories.{DirectionsRepository, ElevationRepository}
import repositories.DirectionsRepository._
import utils.MathUtils._

object Core {

  def elevationProfile(from: String, to: String, dr: DirectionsRepository, er: ElevationRepository): Either[String, List[EnhancedElevationProfile]] = {
    for {
      valid             <- validate(from, to).right
      directionsURL     <- dr.directionsURL(dr.encode(from), dr.encode(to)).right
      directionsJSON    <- dr.request(directionsURL).right
      routes            <- toRoutes(directionsJSON).right
      coordinates       <- routes2coordinates(routes).right
      elevationURL      <- er.elevationURL(coordinates).right
      elevationJSON     <- er.request(elevationURL).right
      latLonElevMap     <- latLonElevMap(elevationJSON).right
      elevationProfiles <- routes2XYs(routes, latLonElevMap).right
    } yield elevationProfiles.map(_.toEnhancedElevationProfile)
  }

  def routes2XYs(routes: List[Route], lleMap: Map[LatLon, Double]): Either[String, List[ElevationProfile]] = {
    Right(routes.map((r: Route) => route2XYs(r, lleMap)))
  }

  def route2XYs(route: Route, lleMap: Map[LatLon, Double]): ElevationProfile = {
    val latLons: List[LatLon]   = route.steps.flatMap((s: Step) => List(s.start, s.end)).distinct
    val distances: List[Double] = latLons.sliding(2).toList.map((l: List[LatLon]) => distance(l.head, l.last))
    val cumulates               = accumulate(0 :: distances)

    val xys = (latLons zip cumulates).map(p => XY(p._2.toString.toDouble, lleMap(p._1)))
    new ElevationProfile(xys)
  }
}