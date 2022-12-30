package com.scalaSpark.SparkBasics

import org.apache.log4j.{Level, Logger}
import org.apache.spark.SparkContext

/**
  * Created by Rishabh on 02,May,2020
  */
object CustomerSpent {

  def main(args: Array[String]): Unit = {

    Logger.getLogger("org").setLevel(Level.ERROR)
    val sc = new SparkContext("local[*]","CustomerSpent")

    val customerData = sc.textFile("C:\\Users\\SUNNY\\Desktop\\SCALA\\SparkScala\\customer-orders.csv")
    println(customerData.getNumPartitions)

    def parseLine(lines:String) ={
      val line = lines.split(",")
      val customerId = line(0).toInt
      val amount = line(2).toFloat
      (customerId,amount)
    }

    val customerSpent = customerData.map(parseLine).reduceByKey((x,y) => x + y).sortByKey()
    val result = customerSpent.collect()

    result.foreach(println)
  }
}
