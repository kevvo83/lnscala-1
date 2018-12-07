package com.investigate.implicitsvsypes

trait ChatCapability[T] {
  def chatImplementation(x: T): String
}
