package utils

import models.Models.LatLon
import org.scalatest.FunSpec
import MathUtils._

class TestMathUtils extends FunSpec {
  describe(".distance") {
    val from  = LatLon(-37.8168987, 144.9955671)
    val to    = LatLon(-37.816969 , 144.9961949)

    it("calculates th distance between two points") {
      assert(distance(from, to) == 56)
    }
  }

  describe(".deg2rad") {
    it("converts degrees into radiants") {
      assert(deg2rad(90) == 1.5707963267948966)
    }
  }

  describe(".accumulate") {
    val values    = List(0.0, 10.0, 20.0, 30.0)
    val expected  = List(0, 10, 30, 60)

    it("accumulates the values") {
      assert(accumulate(values) == expected)
    }
  }

  describe(".midpoint") {
    val a = LatLon(41.9028, 12.4964)
    val b = LatLon(40.8518, 14.2681)
    val c = LatLon(41.380696630055574, 13.389407987272127)

    it("calculates the midpoint between two locations") {
      assert(midpoint(a, b) == c)
    }
  }

  describe(".interpolate") {
    val original_list = List(LatLon(41.9028, 12.4964), LatLon(41.380696630055574, 13.389407987272127), LatLon(40.8518, 14.2681))
    val expected_list = List(LatLon(41.9028,12.4964), LatLon(41.64261223850071,12.944712890468985), LatLon(41.380696630055574,13.389407987272127), LatLon(41.11708281363663,13.830524015435849), LatLon(40.8518,14.2681))

    it("adds more points to a list of coordinates") {
      assert(interpolate(original_list).right.get == expected_list)
    }
  }
}