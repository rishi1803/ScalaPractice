package com.scalaSpark.SparkBasics

import org.apache.log4j.{Level, Logger}
import org.apache.spark.SparkContext
import scala.math.min

/**
  * Created by Rishabh on 02,May,2020
  */
object MinTemperatures {

  def main(args: Array[String]): Unit = {

    Logger.getLogger("org").setLevel(Level.ERROR)
    val sc = new SparkContext("local[*]","MinTemp")

    def parseLine(line : String) = {
      val lines = line.split(",")
      val stationId = lines(0)
      val entryType = lines(2)
      val temperature = lines(3).toFloat * 0.1f * (5.0f/9.0f) + 32.0f
      (stationId,entryType,temperature)
    }

    val temperaturesList = sc.textFile("C:\\Users\\SUNNY\\Desktop\\SCALA\\SparkScala\\1800.csv")
//    temperaturesList.collect()
//    temperaturesList.foreach(println)
    val tempListFilter = temperaturesList.map(parseLine)
    val minTempStationList = tempListFilter.filter(x => x._2 == "TMIN").map(x => (x._1,x._3))
//    minTempStationList.foreach(println)
    val minTempStation = minTempStationList.reduceByKey((x,y) => min(x,y))
//    minTempStation.foreach(println)
     val results = minTempStation.collect()

    for (result <- results.sorted/*.reverse*/) {
      val station = result._1
      val temp = result._2
      val formattedTemp = f"$temp%.2f F"
      println(s"$station minimum temperature: $formattedTemp")
    }

  }
}
