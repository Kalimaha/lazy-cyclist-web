package repositories

import scalaj.http._


trait GoogleAPIRepository {
  val BASE_URL = ""

  def encode(address: String): String = address.replaceAll(" ", "+")

  def request(url: String): Either[String, String] = {
    val response = Http(url).asString

    response.code match {
      case x if x > 299 => Left(response.body.trim)
      case _            => Right(response.body.trim)
    }
  }
}
