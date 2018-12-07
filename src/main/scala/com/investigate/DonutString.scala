package com.investigate

class DonutString(description: String) {
  def isFavouriteDonut: Boolean = description == "Glazed Donut"
}

// Companion Object - Static Object available to all Instances of DonutString
object DonutString {

  private var numInstances: Int = 0

  def apply(desc: String): DonutString = {
    new DonutString(desc)
  }

  // Factory Create Method of the DonutString
  def create[A](inputparam:Option[A]): Option[DonutString] = {
    inputparam match {
      case d: Option[String] => Some(new DonutString(s"${d.getOrElse("")}"))
      case d: Option[Int] => Some(new DonutString(s"Int passed ${d.getOrElse(999)}"))
      case _ => None
    }
   //numInstances += 1
  }

  def getNumInstances: Int = numInstances

}