package repositories

case class DirectionsRepository(apiKey: String) extends GoogleAPIRepository {
  override val BASE_URL = "https://maps.googleapis.com/maps/api/directions/json?"

  def directionsURL(from: String, to: String): Either[String, String] = apiKey match {
    case null => Left("Parameter 'directionsAPIKey' can't be null.")
    case ""   => Left("Parameter 'directionsAPIKey' can't be empty.")
    case key  => Right(s"${BASE_URL}origin=$from&destination=$to&key=$key&mode=bicycling&alternatives=true&avoid=ferries")
  }
}

object DirectionsRepository {
  def validate(from: String, to: String): Either[String, Boolean] = (from, to) match {
    case ("", _)    => Left("Parameter 'from' can't be empty.")
    case (_, "")    => Left("Parameter 'to' can't be empty.")
    case (null, _)  => Left("Parameter 'from' can't be null.")
    case (_, null)  => Left("Parameter 'to' can't be null.")

    case (_, _)     => Right(true)
  }
}