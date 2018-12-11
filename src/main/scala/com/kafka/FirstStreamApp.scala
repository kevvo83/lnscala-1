package com.kafka

import com.typesafe.config._
import com.typesafe.scalalogging.StrictLogging

import scala.util.{Properties => SProp}
import java.util.{Properties => JProp}

import org.apache.kafka.streams.kstream.{KStream, Materialized}
import org.apache.kafka.streams.{KafkaStreams, StreamsBuilder, StreamsConfig}
import org.apache.kafka.common.serialization.Serdes._

object FirstStreamApp extends App with StrictLogging {

  val conf = ConfigFactory.load("application.json")

  SProp.setProp("StreamsConfig.APPLICATION_ID_CONFIG",conf.getString("StreamsConfig.APPLICATION_ID_CONFIG"))
  SProp.setProp("StreamsConfig.BOOTSTRAP_SERVERS_CONFIG",conf.getString("StreamsConfig.BOOTSTRAP_SERVERS_CONFIG"))

  val builder: StreamsBuilder = new StreamsBuilder
  val textLines: KStream[String, String] = builder.stream[String, String]("my-replicated-topic")
}