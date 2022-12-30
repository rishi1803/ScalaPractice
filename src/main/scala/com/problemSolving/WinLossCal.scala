package com.problemSolving

import org.apache.spark.sql.functions._
import org.apache.spark.sql.types.{StringType, StructType}
import org.apache.spark.sql.{Row, SparkSession}
import com.typesafe.config.{Config, ConfigFactory}

object WinLossCal extends App{

  val deployMode = ConfigFactory.load().getConfig("spark").getString("spark.submit.deployMode")
  println(s"value is : $deployMode")

  def setupLogging() = {
    import org.apache.log4j.{Level, Logger}
    val rootLogger = Logger.getLogger("org")
    rootLogger.setLevel(Level.ERROR)
  }

  setupLogging()

  val spark= SparkSession.builder
    .appName("WinLoss")
    .master("spark://192.168.1.5:7077")
    .config("spark.sql.warehouse.dir","file:///C:/temp")
    .config("spark.submit.deployMode",deployMode)
    .config("spark.history.ui.port",18080)
    .config("spark.eventLog.enabled",true)
    .config("spark.history.store.path","C:\\tmp\\spark-events")
    .config("spark.ui.port",4050)
    .config("spark.jars","C:\\Users\\sony\\Intellij_Projects\\IdeaProjects\\ScalaPractice\\target\\essential-scala-1.0-SNAPSHOT.jar")
    .getOrCreate()

  val data =Seq(Row("India","SriLanka","India"),
    Row("Aus","SriLanka","Aus"),
    Row("India","Aus","India"),
    Row("India","Aus","India")
  )

  val schema = new StructType()
    .add("team1",StringType)
    .add("team2",StringType)
    .add("winner",StringType)

  val df =spark.createDataFrame(spark.sparkContext.parallelize(data),schema)
  df.printSchema()
  df.show(false)
  df.cache()

  val df2 = df.select(col("team1").as("team"))
  val df3 = df.select(col("team2").as("team"))

  val df4 = df2.union(df3).distinct()//.show(false)
  df4.show(false)
  df4.cache()

  val df5 = df4.join(df,df4("team") === df("team1"),"inner")
  val df6 = df4.join(df,df4("team") === df("team2") ,"inner")
  val df7 = df5.union(df6)
  df7.show(false)

  val df8 = df7.groupBy("team").agg(
    count("team").as("total_match"),
    count(when(col("winner") === col("team"),lit(1))).as("total_win"),
    count(when(col("winner") =!= col("team"),lit(1))).as("total_loss")
  )
  df8.show()

//  val df9 = df8.withColumn("total_loss",col("total_match") - col("total_win")).show
//  val df2 = df.createOrReplaceTempView("team")
//  val qry =spark.sql("select ")


}
