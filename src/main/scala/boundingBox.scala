package edu.luc.cs.laufer.cs372.shapes

// TODO: implement this behavior

object boundingBox {
  def apply(s: Shape): Location = s match {

    case Ellipse(semimajoraxis: Int, semiminoraxis: Int) => Location(-semimajoraxis, -semiminoraxis, Rectangle(semimajoraxis * 2, semiminoraxis * 2))
    case Rectangle(width: Int, height: Int)              => Location(0, 0, Rectangle(width, height))
    case Location(x: Int, y: Int, shape: Shape)          => Location(x + apply(shape).x, y + apply(shape).y, apply(shape).shape)

    case Group(shapes @ _*)                              => calgroupboundingbox(Group(shapes: _*))

  }

  def calgroupboundingbox(shapes: Group): Location = {

    //var boundboxlist = List.empty

    var xmin = 0
    var xmax = 0
    var ymin = 0
    var ymax = 0
    var xlist = List.empty
    var ylist = List.empty
    var xmaxlist = List.empty
    var ymaxlist = List.empty

    for (shape <- shapes) {

      var rec = apply(shape).shape.asInstanceOf[Rectangle]

      xlist :+ apply(shape).x
      ylist :+ apply(shape).y
      xmaxlist :+ apply(shape).x + rec.width
      ymaxlist :+ apply(shape).y + rec.height
    }

    xmax = xmaxlist.max
    xmin = xlist.min

    ymax = ymaxlist.max
    ymin = ylist.min

    Location(xmin, ymin, Rectangle(xmax - xmin, ymax - ymin))

  }

}
