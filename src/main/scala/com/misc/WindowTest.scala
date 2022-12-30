package com.misc

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object WindowTest extends App {

  import util.Random
  import org.apache.spark.sql.functions._

  def setupLogging() = {
    import org.apache.log4j.{Level, Logger}
    val rootLogger = Logger.getLogger("org")
    rootLogger.setLevel(Level.ERROR)
  }

  setupLogging()

  val spark = SparkSession.builder
    .appName("WindowsTest")
    .master("spark://192.168.1.5:7077")
    .config("spark.sql.warehouse.dir","file:///C:/temp")
    //.config("spark.submit.deployMode",deployMode)
    .config("spark.history.ui.port",18080)
    .config("spark.eventLog.enabled",true)
    .config("spark.history.store.path","C:\\tmp\\spark-events")
    .config("spark.ui.port",4050)
    .config("spark.jars","C:\\Users\\sony\\Intellij_Projects\\IdeaProjects\\ScalaPractice\\target\\essential-scala-1.0-SNAPSHOT.jar")
    .getOrCreate()

  import spark.implicits._
  val maxX = 500000
  val nrow = maxX*10
  val randomList = Seq.fill(nrow)((Random.nextInt(maxX), Random.nextInt, Random.nextInt))

  val df = spark.sparkContext.parallelize(randomList).toDF("x", "y", "z")
  df.show(20,false)

  val startTime = System.currentTimeMillis()

  val dfAgg = df.groupBy("x").agg(max("y").as("max_y"))
  dfAgg.show(10,false)
  val dfJoined = df.join(dfAgg, "x")

  dfJoined.explain()

}
