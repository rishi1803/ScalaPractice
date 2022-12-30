package com.scalaSpark.LearningSpark

import org.apache.log4j.{Level, Logger}
import org.apache.spark.SparkContext


/**
 * Created by Rishabh on 23,May,2020
 */
object LoadMultipleFiels {

  def main(args: Array[String]): Unit = {

    Logger.getLogger("org").setLevel(Level.ERROR)

    val spark = new SparkContext("local[*]","LoadMultipleFiles")

//    val load = spark.wholeTextFiles("C:\\Users\\SUNNY\\Desktop\\Spark\\*.txt")
//    load.foreach(f => {
//      println( f._1 +" => "+ f._2)
//    })

    val load = spark.textFile("C:\\Users\\SUNNY\\Desktop\\Spark\\*.txt")
//    println(load)
//    load.saveAsTextFile("C:\\Users\\SUNNY\\Desktop\\Spark\\new_folder")

  }

}
