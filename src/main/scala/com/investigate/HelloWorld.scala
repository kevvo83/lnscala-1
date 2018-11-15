package com.investigate

import com.typesafe.scalalogging.LazyLogging

object HelloWorld extends App with LazyLogging {
  println("Hello World, first time scala class/object")
  println(args.mkString(", "))
  logger.info("First Lazy Logging message!")

  // Types
  // val is immutable
  // var is mutable

  // String Interpolation Example 1
  val testString: String = "Hello Hello, testing types"
  logger.info("test string content " + testString)

  // String Interpolation example using println(s)
  val testString1: String = "Bugatti Veyron"
  println(s"Fastest Production car in the world for many years was the ${testString1}")

  // String Interpolation example - println(f) is for formatting numbers
  val topSpeed: Float = 288.2f
  println(f"Topspeed of the worlds Fastest Production Car was ${topSpeed}%.5f")

  // Case Class is a Class that comes with Getter and Setter methods, so no Boilerplate code required
  case class FastestProductionCar(name: String, speed: Float)
  val fastestProdCar: FastestProductionCar = FastestProductionCar(name="Bugatti Chiron", speed=320.12f)
  println(f"Current Fastest Production Car is ${fastestProdCar.name} and it's top speed is ${fastestProdCar.speed}%.4f")

  // String Escaping - Backslash also works
  val jsonString: String = """{"name":"Jason", "weight":32.01, "height":168.04}"""
  println(s"Jason's Physical attributes in json format are ${jsonString}")

  val donutJson4: String =
    """
      |{
      |"donut_name":"Glazed Donut",
      |"taste_level":"Very Tasty",
      |"price":2.50
      |}
    """.stripMargin

  // If-Else to do direct Assignment
  val defaultNumberWheels: Int = 4
  val numberOfWheelsToBuy: Int = if(fastestProdCar.name == "Bugatti Chiron") defaultNumberWheels else 8
  println(s"Total Number of wheels to be Purchased for the ${fastestProdCar.name} are ${numberOfWheelsToBuy}")

  // For, Lists
  val listOfCarsInventory = List("Bugatti","Ferrari","Lamborghini","Audi")
  for (carInInventory <- listOfCarsInventory if carInInventory != "Lamborghini"){
    println(s"Car in the Inventory that is available for View ${carInInventory}")
  }

  // For List Yield - the Forloop returns a value to immutable variable.
  val listOfCarsForView = for (
    car <- listOfCarsInventory if car != "Lamborghini"
  ) yield car
  println(s"Alternate View of Cars in Inventory that are available for View ${listOfCarsForView}")

  // Simple Matching
  val carImInterestedIn = "BMW"
  val manufactureYear = carImInterestedIn match {
    case "Lancia" | "BMW" => "1970"
    case "Mercedes" => "1920"
    case "Toyota" => "1925"
    case "_"  => "1999"
  }
  println (s"Car I like is ${carImInterestedIn} and it was built in ${manufactureYear}")

  val lanciaAttrib = Tuple3("Lancia",10000, "1920")
  val bmwAttrib = Tuple3("BMW",20000.0f, "1999")
  val mercedesAttrib = Tuple3("Mercedes",25002, "1985")
  val listOfCars = List(lanciaAttrib, bmwAttrib, mercedesAttrib)

  println(s"BMW Price is ${bmwAttrib._2}")

  listOfCars.foreach {
    _._1 match {
      case "Lancia" => println("Lancia's are classic Italian sports cars")
      case "BMW" => println("BMW's are world-renowed Car Manufacturer out of the Bavaria region in Germany")
      case "Mercedes" => println("Mercedes-Benz is the super high-class car manufacturer out of Germany")
      case _ => println(s"Information Pending")
    }
  }
}
