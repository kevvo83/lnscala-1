package com.investigate.implicitsvsypes

object Car {

  // Implicit Function Definition
  implicit def convertStringToCar(csvDescriptor: String): CarDefinition = {
    var arr = csvDescriptor.split(";")
    new CarDefinition(arr(0), arr(1), arr(2))
  }
}
