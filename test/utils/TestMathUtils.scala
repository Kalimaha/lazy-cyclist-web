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
    val a = LatLon(41.54, 12.30)
    val b = LatLon(40.50, 14.15)
    val c = LatLon(41.36997999996239, 13.382173000045697)

    it("calculates the midpoint between two locations") {
      assert(midpoint(a, b) == c)
    }
  }
}