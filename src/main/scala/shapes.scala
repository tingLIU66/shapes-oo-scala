package edu.luc.cs.laufer.cs372.shapes

/**
  * data Shape = Rectangle(w, h) | Location(x, y, Shape)
  */
sealed trait Shape

case class Ellipse(semimajoraxis:Int, semiminoraxis:Int) extends Shape{
  require(semimajoraxis >= 0, "invalid major axis")
  require(semiminoraxis >= 0, "invalid minor axis")

}

case class Rectangle(width: Int, height: Int) extends Shape

case class Location(x: Int, y: Int, shape: Shape) extends Shape {
  require(shape != null, "null shape in location")
}

case class Group(shape : Shape*) extends Shape{
  require(shape != null, "null shape in group")

}





// TODO add missing case classes (see test fixtures)
// TODO must include validity checking for constructor arguments
