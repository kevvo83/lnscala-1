package com.investigate

import com.typesafe.scalalogging.StrictLogging

object Functions extends App with StrictLogging{

  def testFunction1 (unitPrice: Float)(implicit discount: Float): Float = {
    unitPrice * (1-discount)
  }

  // This Implicit val gets pickedup and used, even though the name is different -
  //    What is the same is only the data type.
  implicit val discountbyanothername: Float = 1.0f
  logger.info(s"${testFunction1(2.5f)}")

  // Calling this function directly - instead of waiting for an Implicit Float to be defined in scope.
  logger.info(s"${testFunction1(2.5f)(0.5f)}")


  //Typed Method or Function or idunnowhatfuck
  def test[A](inputParam: A): A = {
    inputParam match {
      case _: Int => 1
      case _: Float => 1.0f
    }
  }
  val test1:Float = test[Int](5)
  val test2:Float = test[Float](50.0f)
  logger.info(s"Test1 result if ${test1}, and the Test2 result is ${test2}")
}
