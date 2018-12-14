package com.investigate.inheritances

abstract class Animal {
  def describe: Unit
  val name: String
}

case class Dog(val name: String) extends Animal {
  override def describe: Unit = {println(s"Dog Print - Name ${name}")}
}

case class Cat(name: String) extends Animal {
  override def describe: Unit = {println(s"Cat Print - Name ${name}")}
}
