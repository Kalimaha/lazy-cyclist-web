package repositories

import org.scalatest.{BeforeAndAfter, FunSpec}
import models.Models.LatLon

class TestElevationClient extends FunSpec with BeforeAndAfter {
  var client: ElevationRepository = _

  before {
    client = new ElevationRepository(apiKey = "abc123")
  }

  describe(".elevationURL") {
    val url = "https://maps.googleapis.com/maps/api/elevation/json?key=abc123&locations=1.2,3.4|5.6,7.8"

    describe("when the list of coordinates is NOT empty") {
      val coordinates = List(LatLon(1.2, 3.4), LatLon(5.6, 7.8))

      it("creates the URL for the API request") {
        assert(client.elevationURL(coordinates) == Right(url))
      }
    }

    describe("when the list of coordinates IS empty") {
      val coordinates = List()

      it("creates the URL for the API request") {
        assert(client.elevationURL(coordinates) == Left("The list of coordinates is empty."))
      }
    }
  }

  describe(".encode") {
    val ll = LatLon(1.2, 2.3)

    it("converts a LatLon into a string") {
      assert(ElevationRepository.encode(ll) == "1.2,2.3")
    }
  }
}