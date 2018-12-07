package com.investigate.implicitsvsypes

object PersonThatCanChat extends ChatCapability[Person] {
  def chatImplementation(x: Person): String = {
    "Hello, My name is ".concat(x.firstName.concat(x.familyName))
  }
}
