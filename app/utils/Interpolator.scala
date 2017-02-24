package utils

import models.Models.{Route, Step}
import utils.MathUtils._

object Interpolator {
  def interpolateRoutes(routes: List[Route]): Either[String, List[Route]] = Right(routes.map(r => interpolate(r)))

  def interpolate(route: Route): Route = Route(interpolate(route.steps))

  def interpolate(steps: List[Step]): List[Step] = {
    steps.flatMap(step => {
      val mid = midpoint(step.start, step.end)
      val s1  = Step(distance(step.start, mid).toInt, step.start, mid)
      val s2  = Step(distance(mid, step.end).toInt, mid, step.end)

      List(s1, s2)
    })
  }
}