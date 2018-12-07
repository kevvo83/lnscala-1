package object Donut {

  case class Donut(desc: String, price: Float, origin: Option[String])

  implicit class DonutImplicit(donut: Donut) {
    def uuid: String = s"${donut.desc}-${donut.origin.getOrElse("notavail")}"
  }
}
