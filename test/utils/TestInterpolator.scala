package utils

import models.Models.{LatLon, Route, Step}
import org.scalatest.FunSpec
import utils.Interpolator._

class TestInterpolator extends FunSpec {
  describe(".interpolate (List[Route])") {
    val a = LatLon(41.9028, 12.4964)
    val b = LatLon(40.8518, 14.2681)
    val c = LatLon(41.380696630055574, 13.389407987272127)

    val s0 = Step(188400, a, b)
    val s1 = Step(94247, a, c)
    val s2 = Step(94247, c, b)

    val r1 = Route(List(s0))
    val r2 = Route(List(s1, s2))

    it("add extra steps to the route") {
      assert(interpolateRoutes(List(r1)).right.get == List(r2))
    }
  }

  describe(".interpolate (Route)") {
    val a = LatLon(41.9028, 12.4964)
    val b = LatLon(40.8518, 14.2681)
    val c = LatLon(41.380696630055574, 13.389407987272127)

    val s0 = Step(188400, a, b)
    val s1 = Step(94247, a, c)
    val s2 = Step(94247, c, b)

    val r1 = Route(List(s0))
    val r2 = Route(List(s1, s2))

    it("add extra steps to the route") {
      assert(interpolate(r1) == r2)
    }
  }

  describe(".interpolate (List[Step])") {
    val a = LatLon(41.9028, 12.4964)
    val b = LatLon(40.8518, 14.2681)
    val c = LatLon(41.380696630055574, 13.389407987272127)

    val s0 = Step(188400, a, b)
    val s1 = Step(94247, a, c)
    val s2 = Step(94247, c, b)


    it("breaks a step into two") {
      assert(interpolate(List(s0)) == List(s1, s2))
    }
  }
}