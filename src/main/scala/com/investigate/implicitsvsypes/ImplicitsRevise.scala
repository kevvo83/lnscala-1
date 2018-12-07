package com.investigate.implicitsvsypes

import com.investigate.implicitsvsypes.Car._
import com.typesafe.scalalogging.StrictLogging


object ImplicitsRevise extends App with StrictLogging{

  // The string "Honda;Accord;2018" doesnt have a method named getMake. But CarDefinition Class has such a method
  //    Due to import above (i.e. Car._), there is a method that accepts a String input and returns a CarDefinition output
  //    That implicit function is executed - and this returns an object of CarDefinition

  // Implicit Functions are used for Implicit Conversions (this is the most useful usecase I can see right now)
  logger.info(s"Implicit Function Test: ${"Honda;Accord;2018".getMake}")
  logger.info(s"Implicit Funciton Test ${"Honda;Accord;2018".getModel}")

  // IMPLICITS - Implicit Parameters (i.e. function params that are left out during call) vs. Implicit Conversions (Implicit Class, and Implicit Functions too I think).
  // https://www.theguardian.com/info/developer-blog/2016/dec/22/parental-advisory-implicit-content


  // I still don't understand how Implicit Classes work - I believe they are similar to Implicit Function in terms of what the compiler is doing.
  // Need to definitely research more into this asap


  // Example of Type Classes - Are Traits Type Classes?
  logger.info(s"${PersonThatCanChat.chatImplementation(Person("Jack","Reacher",52))}")


  // I see that Implicit Parameters are used for Context passing


  // Package Object Test
  val dt:DateTime = new DateTime()


  // Traits
  var spc: ShoppingCartInstance = new ShoppingCartInstance()

  spc.addItem(new ShopItem(1,"Chocolate Donut", 2.50f))
  spc.addItem(new ShopItem(2,"Glazed Donut", 2.51f))
  spc.addItem(new ShopItem(3,"Washing Powder", 12.51f))
  spc.addItem(new ShopItem(1,"Coconut Water", 12.20f))

  logger.info(s"Total Bill: ${spc.computeTotalBill}")
  logger.info(s"View items in Bill: ${spc.listBillForReference}")

}
