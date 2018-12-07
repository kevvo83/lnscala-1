package com.investigate

import com.typesafe.scalalogging.StrictLogging

object Logger extends StrictLogging {
  def informacion(desc: String): Unit = {
    logger.info(s"New Class, ${desc}")
  }
}
