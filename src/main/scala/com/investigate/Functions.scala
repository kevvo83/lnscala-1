package com.investigate

import com.typesafe.scalalogging.StrictLogging
import Logger.informacion

object Functions extends App with StrictLogging {

  // Defined Function that accepts Implicit Parameters
  def testFunction1(unitPrice: Float)(implicit discount: Float): Float = {
    unitPrice * (1 - discount)
  }

  // Functions with Implicit Parameters are used for Dependency Injection

  // This Implicit val gets pickedup and used, even though the name is different -
  //    What is the same is only the data type.
  implicit val discountbyanothername: Float = 1.0f
  logger.info(s"${testFunction1(2.5f)}")

  // IFF this Implicit Val Float is also defined in scope, Compilation will fail with the error - "Ambiguous Implicit Values"
  // implicit val secondDiscount: Float = 2.0f
  logger.info(s"${testFunction1(5.0f)}")

  // Calling this function directly - instead of waiting for an Implicit Float to be defined in scope.
  logger.info(s"${testFunction1(2.5f)(0.5f)}")

  val newObj: DonutString = new DonutString("Chocolate Sprinkles")
  logger.info(s"${newObj.isFavouriteDonut}")

  // Implicit Functions are used for Class Extensions for example
  // https://stackoverflow.com/questions/50593346/implicit-functions-in-scala-how-is-this-working
  implicit def convertStringToDonutString(tobecon: String) = new DonutString(tobecon)

  var res1 = "Chocolate Sprinkles".isFavouriteDonut
  var res2 = "Sugar Coated".isFavouriteDonut
  var res3 = "Glazed Donut".isFavouriteDonut

  logger.info(s"Res1: ${res1}, Res2: ${res2}, Res3: ${res3}")


  // Typed Functions - simple example of my own, but can be better.
  def checkCarsInInventory[T](id: T): String = {
    val inventory: Map[Int, String] = Map(
      1 -> "Lamborghini",
      2 -> "Ferrari",
      3 -> "Honda"
    )

    id match {
      case id: Int => inventory.getOrElse(id, "Not Found")
      case id: String => "Not Right Use-case"
      case _ => "Failure"
    }

  }

  logger.info(s"${checkCarsInInventory[Int](1)}")
  logger.info(s"${checkCarsInInventory[Int](3)}")
  logger.info(s"${checkCarsInInventory[String]("Toyota")}")


  // List vs. Seqs relationship explained - https://stackoverflow.com/questions/10866639/difference-between-a-seq-and-a-list-in-scala



  implicit val SupermarketInventory: Map[String, Float] = Map(
    "Ketchup" -> 3.50f,
    "Washing Powder"  -> 18.9f,
    "Dental Floss"    -> 21.345f,
    "Toothpaste"      -> 8.91f
  )

  //  Currying Functions and use with Partial Functions
  //  FYI - Curried Functions will build chains of Functions

  // Curried Function - with an Implicit Map used as Inventory
  def costCalculation(itemDesc: String)(quantity: Int)(discount: Float)(implicit inventory: Map[String, Float]): Float = {
    inventory.getOrElse(itemDesc, 0.0f) * quantity * (1-discount)
  }

  val costOfToothpaste = costCalculation("Toothpaste") _

  logger.info(s"${costOfToothpaste(5)(0.40f)}")
  logger.info(s"${costOfToothpaste(2)(0.00f)}")

  val foo = List(1,2,3,4,5)

  val hd = foo.head
  val hdOpt = foo.headOption
  val tl = foo.tail


  // Had Trouble figuring out the syntax of Anonymous Functions and of each element of the List
  //  Looked at the example defining an inline function in a List.foreach usecase.
  val listOrders = List(("Glazed Donut", 5, 2.50), ("Vanilla Donut", 10, 3.50))

  def placeOrder(orderList:List[(String, Int, Double)])(localExchangeRate: Double): Double = {
    var totalBill: Double = 0

    orderList.foreach(orderDetails => {
      totalBill += orderDetails._2 * orderDetails._3 * localExchangeRate
    })
    totalBill

  }
  def placeOrderFunc = placeOrder(listOrders) _
  logger.info(s"Total Cost of the Orders ${placeOrderFunc(0.90)}")

  def exchangeRate:Double = {
    val map:Map[String, Double] = Map(
      "GBP" -> 0.80,
      "USD" -> 0.90,
      "EUR" -> 0.75,
      "SGD" -> 1.00
    )
    map.getOrElse("USD", 1.00)
  }

  def placeOrder_2(orderList:List[(String, Int, Double)])(exchangeRate: => Double): Double = {

    var totalBill: Double = 0

    orderList.foreach(orderDetails => {
      totalBill += orderDetails._2 * orderDetails._3 * exchangeRate
    })
    totalBill

  }

  val placeOrder_2_placeholder = placeOrder_2(listOrders) _

  logger.info(s"Result: ${placeOrder_2_placeholder(exchangeRate)}")



  // Tail Recursive Iteration over a List
  def iterateOveList(list:List[Int]): List[Int] = {
    if (list.isEmpty) list
    else {
      logger.info(s"Tail Recursive Function that iterates over List: ${list}")
      iterateOveList(list.tail)
    }
  }
  iterateOveList(List(1,2,3,4,5,6,7,8))


  // Tail Recursive Function that iterates over a List and only returns the Even Numbers
  def iterateOverListAndReturnRequiredNumbers(list:List[Int], funcToCheckIfEvenElement:Int => Boolean): List[Int] = {
    if (list.isEmpty) list
    else if (funcToCheckIfEvenElement(list.head)) {
      list.head :: iterateOverListAndReturnRequiredNumbers(list.tail, funcToCheckIfEvenElement)
    }
    else {
      iterateOverListAndReturnRequiredNumbers(list.tail, funcToCheckIfEvenElement)
    }
  }

  def checkIfExactlyDivisible(y:Int)(x:Int): Boolean = ((x % y) == 0)
  def checkIfEvenElement = checkIfExactlyDivisible(2) _
  def checkIfMultiplierOf3Element = checkIfExactlyDivisible(3) _

  logger.info(s"iterate over list and return Even Numbers: ${iterateOverListAndReturnRequiredNumbers(List(1,2,3,4,5,6,7,8,9), checkIfEvenElement)}")
  logger.info(s"iterate over list and return Numbers that are Multiples of 3: ${iterateOverListAndReturnRequiredNumbers(List(1,2,3,4,5,6,7,8,9), checkIfMultiplierOf3Element)}")


  case class Donut(id:Int, name:String)
  val donut1:Donut = Donut(1, "Glazed")

  val donut2:DonutString = DonutString.apply("Sugar Coated")
  val donut3:DonutString = DonutString("Maple Syrup Coated")

  // Defined in Logger class that I've defined
  informacion("Calling a method that's defined in an Object that extends a Class")

}