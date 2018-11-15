package com.investigate

import com.typesafe.scalalogging.LazyLogging
import scala.collection.mutable.HashMap

object Chapter3 extends App {

  def getUnitPrice(brandName: String): Option[Float] = {

    val unitPriceMap: HashMap[String, Float] = HashMap(
      ("Maserati",2500.0f),
      ("Ferrari",1850.0f),
      ("Bugatti",2890.0f)
    )

    unitPriceMap.get(brandName)

  }

  def computeTotalCost(brandName: String, numUnits: Int): Float = {
    val totalCost: Float = getUnitPrice(brandName) match {
      case Some(x) => x * numUnits
      case None => 0.0f
    }
    totalCost
  }

  def getTodaysOffers(productType: String): Option[String] = {
    val productVsOffers: HashMap[String, String] = HashMap(
      ("Beans", "50% Off"),
      ("Chicken", "Everything Must Go!"),
      ("Beef", "Kobe Beef is 20% Off - Radioactive Deal!!!")
    )
    productVsOffers.get(productType)
  }

  // Method 1 - Using .getOrElse to process potential NULLS from a function that returns an Option
  println(s"Offers on Chicken today?: ${getTodaysOffers("Chicken").getOrElse("No Offers on Chicken Today!!!")}")
  println(s"Offers on Kangaroo Meat today?: ${getTodaysOffers("Kangaroo Meat").getOrElse("No Offers on Kangaroo Meat Today!!!")}")

  val brand: String="Maserati"
  val units: Int =3

  // Method 2 - Use Regular Expression Matching to process potential NULLS from a function that returns an Option
  println(s"Total Cost of ${units} units of ${brand} is ${computeTotalCost("Maserati",5)}")
  println(s"Total Cost of ${units} units of ${brand} is ${computeTotalCost("Ferrari",10)}")
  println(s"Total Cost of ${units} units of ${brand} is ${computeTotalCost("Mercedes",10)}")

  // Method 3 - Using map() Function to filter out the None values
  val listOfLuxuryCarBrands: Seq[AnyRef] = Seq("Maserati","Ferrari","Lexus","Pagani",None)
  listOfLuxuryCarBrands.foreach(println(_))


  val listofPrices: List[Float] = List(20.1f, 20.3f, 20.34f, 90.1f)
  val modlistofPrices: List[Float] = listofPrices.map(num => num * 2)
  modlistofPrices.foreach(num => println(s"Newly Computed numbers are ${num}"))

}
