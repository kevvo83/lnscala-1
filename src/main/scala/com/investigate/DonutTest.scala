package com.investigate

import Donut._
import com.typesafe.scalalogging.StrictLogging

object DonutTest extends App with StrictLogging{

  val donut1 = Donut("Chocolatey Goodness", 2.50f, Some("Spain"))
  logger.info(s"UUID of Donut1 is ${donut1.uuid}")

  val test:Option[DonutString] = DonutString.create[String](Some("Hello There!!"))
  val test2: Option[DonutString] = DonutString.create[Int](Some(22))
  val test4: Option[DonutString] = DonutString.create[Float](Some(22.0f))
  val test3: Option[DonutString] = DonutString.create[String](Some("Glazed Donut"))

  logger.info(s"Done")

  test.map(ip => logger.info(s"TEST: ${ip.isFavouriteDonut}"))
  test2.map(ip => logger.info(s"TEST2: ${ip.isFavouriteDonut}"))
  test3.map(ip => logger.info(s"TEST3: ${ip.isFavouriteDonut}"))
  test4.map(ip => logger.info(s"TEST4: ${ip.isFavouriteDonut}"))

  //test.map{d=>logger.info(d.get)}

  case class TestObj(descriptor: String = "Not Specified")
  val obj1:TestObj = TestObj("First One")

  val testabc = new DonutString("Glazed with Sprinkles")

  // Type Aliasing
  type DonutItemInShoppingCart[DonutString, Int] = Tuple2[DonutString, Int]
  val d1: DonutItemInShoppingCart[DonutString, Int] = new DonutItemInShoppingCart(new DonutString("Glazed with Sprinkles"), 4)
  logger.info(s"A look at the Type Aliased object: ${d1._1}")
  logger.info(s"A look at the Type Aliased object: ${d1._2}") // Looking at elements inside the Tuple
}
