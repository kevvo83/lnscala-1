name := "lnscala-1"

version := "0.1"

scalaVersion := "2.12.6"

libraryDependencies ++= Seq(
  "com.typesafe.scala-logging" %% "scala-logging" % "3.9.0",
  "ch.qos.logback" % "logback-classic" % "1.2.3",
  "joda-time" % "joda-time" % "2.10.1",
  "com.typesafe" % "config" % "1.3.2",
  "org.apache.kafka" %% "kafka" % "2.1.0",
  "org.apache.kafka" % "kafka-clients" % "2.1.0",
  "org.apache.kafka" % "kafka-streams" % "2.1.0"
)