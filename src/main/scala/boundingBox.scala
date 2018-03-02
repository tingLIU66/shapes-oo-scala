package edu.luc.cs.laufer.cs372.shapes

// TODO: implement this behavior

object boundingBox {
  def apply(s: Shape): Location = s match {
    case Rectangle(width: Int, height: Int) => Location(0, 0, Rectangle(width, height)) // not yet implemented
  }
}
