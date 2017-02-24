package core

import models.Models._
import parsers.DirectionsParser._
import parsers.ElevationParser._
import repositories.DirectionsRepository._
import repositories.{DirectionsRepository, ElevationRepository}
import utils.MathUtils._
import utils.Interpolator.interpolateRoutes

object Core {
  def elevationProfile(from: String, to: String, dr: DirectionsRepository, er: ElevationRepository): Either[String, List[EnhancedElevationProfile]] = {
    for {
      valid                 <- validate(from, to).right
      directionsURL         <- dr.directionsURL(dr.encode(from), dr.encode(to)).right
      directionsJSON        <- dr.request(directionsURL).right
      routes                <- toRoutes(directionsJSON).right
      expandedRoutes        <- interpolateRoutes(routes).right
      coordinates           <- routes2coordinates(expandedRoutes).right
      expandedCoordinates   <- interpolate(coordinates).right
      elevationURL          <- er.elevationURL(expandedCoordinates).right
      elevationJSON         <- er.request(elevationURL).right
      latLonElevMap         <- latLonElevMap(elevationJSON).right
      elevationProfiles     <- routes2XYs(expandedRoutes, latLonElevMap).right
    } yield elevationProfiles.map(_.toEnhancedElevationProfile)
  }

  def routes2XYs(routes: List[Route], lleMap: Map[LatLon, Double]): Either[String, List[ElevationProfile]] =
    Right(routes.map((r: Route) => route2XYs(r, lleMap)))

  def route2XYs(route: Route, lleMap: Map[LatLon, Double]): ElevationProfile = {
    val latLons: List[LatLon]   = route.steps.flatMap((s: Step) => List(s.start, s.end)).distinct
    val distances: List[Double] = latLons.sliding(2).toList.map((l: List[LatLon]) => distance(l.head, l.last))
    val cumulates               = accumulate(0 :: distances)

//    val xys = (latLons zip cumulates).map(p => XY(p._2.toString.toDouble, lleMap.getOrElse(p._1, 0)))
    val xys = (latLons zip cumulates).map(p => pippo(p, lleMap))
    new ElevationProfile(xys)
  }

  var previousElevation = 0.0

  def pippo(p: (LatLon, Double), lleMap: Map[LatLon, Double]): XY = {
    try {
      previousElevation = lleMap(p._1)
      return XY(p._2.toString.toDouble, previousElevation)
    } catch {
      case _ => {
        return XY(p._2.toString.toDouble, lleMap.getOrElse(p._1, previousElevation))
      }
    }
  }
}