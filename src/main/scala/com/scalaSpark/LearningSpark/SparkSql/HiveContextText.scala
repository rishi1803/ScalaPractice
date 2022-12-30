package com.scalaSpark.LearningSpark.SparkSql

//import org.apache.spark.sql.hive.HiveContext
import org.apache.log4j.{Level, Logger}
import org.apache.spark.SparkContext
import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.hive.HiveContext

/**
 * Created by Rishabh on 30,May,2020
 */
object HiveContextTest {

  def main(args: Array[String]): Unit = {

    Logger.getLogger("org").setLevel(Level.ERROR)

    val sc = new SparkContext("local[*]","hivecontext")
    val hcxt = new HiveContext(sc)

    val inputFile = hcxt.jsonFile("C:\\Users\\SUNNY\\Desktop\\Spark\\testweet.json")
    inputFile.registerTempTable("tweets")
    val topTweet = hcxt.sql("select text, retweetCount FROM tweets ORDER BY retweetCount LIMIT 10").show(false)
//    val result = topTweet.map()
  }

}
