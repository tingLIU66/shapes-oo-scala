package edu.luc.cs.laufer.cs372.shapes

import BoundingBox.boundingBox
import TestFixtures._

object Main {
  def main(args: Array[String]): Unit = {
    println(boundingBox(simpleLocation))
  }
}
