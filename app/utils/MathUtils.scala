package utils

import models.Models.LatLon
import models.Models.XY

import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer

object MathUtils {
  def distance(from: LatLon, to: LatLon): Double = {
    val dlon  = deg2rad(to.lon - from.lon)
    val dlat  = deg2rad(to.lat - from.lat)
    val a     = Math.pow(Math.sin(dlat / 2), 2) + Math.cos(deg2rad(from.lat)) * Math.cos(deg2rad(to.lat)) * Math.pow(Math.sin(dlon / 2), 2)
    val c     = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a))

    Math.round(6373000 * c)
  }

  def distance(from: XY, to: XY): Double = Math.abs(to.x - from.x)

  def slope(from: XY, to: XY): Double = 100 * (to.y - from.y) / (to.x - from.x)

  def deg2rad(deg: Double): Double = deg * Math.PI / 180
  def rad2deg(deg: Double): Double = deg * 180 / Math.PI

  def accumulate(values: List[Double]): List[Double] = {
    @tailrec
    def loop(values: List[Double], offset: Double, acc: List[Double]): List[Double] = values match {
      case Nil => acc
      case h :: t => loop(t, h + offset, (h + offset) :: acc)
    }

    loop(values, 0, List()).reverse
  }

  def midpoint(a: LatLon, b: LatLon): LatLon = {
    val lat_1 = deg2rad(a.lat)
    val lon_1 = deg2rad(a.lon)
    val lat_2 = deg2rad(b.lat)
    val lon_2 = deg2rad(b.lon)

    val x1 = Math.cos(lat_1) * Math.cos(lon_1)
    val y1 = Math.cos(lat_1) * Math.sin(lon_1)
    val z1 = Math.sin(lat_1)

    val x2 = Math.cos(lat_2) * Math.cos(lon_2)
    val y2 = Math.cos(lat_2) * Math.sin(lon_2)
    val z2 = Math.sin(lat_2)

    val x = (x1 + x2) / 2
    val y = (y1 + y2) / 2
    val z = (z1 + z2) / 2

    val lon = Math.atan2(y, x)
    val hyp = Math.sqrt(x * x + y * y)
    val lat = Math.atan2(z, hyp)

    LatLon(rad2deg(lat), rad2deg(lon))
  }

  def interpolate(l: List[LatLon]): Either[String, List[LatLon]] =
    Right(l.sliding(2).toList.flatMap(l => List(l.head, midpoint(l.head, l.last), l.last)).distinct)
}