package com.investigate.implicitsvsypes

import com.typesafe.scalalogging.StrictLogging

class CarDefinition(make: String, model: String="notdef", modelyear: String="notdef") extends StrictLogging {

  def getModel = this.model
  def getMake = this.make

}
