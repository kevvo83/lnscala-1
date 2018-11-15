package com.investigate

import com.typesafe.scalalogging.StrictLogging


object HelloWorldRevise extends App with StrictLogging{
  val testStringInterpol: String = "This is a Test!"
  val testNumber: Float = 0.5f
  logger.info(f"Hello!!!! ${testStringInterpol}, ${testNumber}")

  // https://docs.scala-lang.org/tour/case-classes.html
  // Attributes in the Case Class are publicly accessible VALS (i.e. are immutable).
  case class DocumentDetail(id:Int, topic:String)

  val document: DocumentDetail = DocumentDetail(1, "This is interesting, i.e. the case class")
  logger.info(s"First doc's ID: ${document.id}, and First doc's Topic: ${document.topic}")

  val document2: DocumentDetail = document.copy(id=2)
  logger.info(s"${document2}")

  def testOptions(productID: Int, productDesc: String,  discountRate: Option[Float]=None): Float = {

    val unitPrice: Float = productID match {
      case 1 => 21.102f
      case 2 => 23.333f
      case 3 => 40.000f
      case _ => 0.0f
    }

    // Handling Options using Pattern Matching
    val _dcR: Float = discountRate match {
      case Some(discountRate) => discountRate
      case None => 1
    }
    unitPrice * _dcR
  }

  // This val is of type "Range"
  val test = 1 to 6

  // This
  val test2: Array[Int] = Array(1,2,3,4,5,6)

  val lazyColl = for (item <- 1 to 6 if item != 5) yield item
  logger.info(s"${lazyColl}") // Type Vector - What is a Range and What is a Vector???

  val lazyColl2:Array[Int] = for (item <- test2 if item != 5) yield item
  logger.info(s"${lazyColl2}") // Returned type is an Array - so the collection Yielded is of the same datatype as the collection iterated over

  logger.info(f"Cost of Heinz Ketchup is ${testOptions(1, "Heinz Ketchup" )}")
  logger.info(f"Cost of Toilet Paper is ${testOptions(3, "Toilet Paper", Some(0.5f) )}")

  val firstMap: Map[Int, String] = Map(1->"First", 2->"Second", (3,"Third"))
  val secondMap: Map[Int, Float] = Map(4->4.0f)

  firstMap

  val ThirdMap = firstMap ++ secondMap
  logger.info(s"${ThirdMap}")

  var res = firstMap.get(1)
  var res2 = secondMap.get(10)
}
