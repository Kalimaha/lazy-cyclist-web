package repositories

import models.Models.LatLon

case class ElevationRepository(apiKey: String) extends GoogleAPIRepository {
  override val BASE_URL = "https://maps.googleapis.com/maps/api/elevation/json?"

  def elevationURL(coordinates: List[LatLon]): Either[String, String] =
    if (coordinates.isEmpty) {
      Left("The list of coordinates is empty.")
    } else {
      val locations = coordinates.map(ElevationRepository.encode).mkString("|")

      Right(s"${BASE_URL}key=$apiKey&locations=$locations")
    }
}

object ElevationRepository {
  def encode(ll: LatLon): String = s"${ll.lat},${ll.lon}"
}