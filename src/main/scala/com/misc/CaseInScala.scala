package com.misc

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.{col, expr, when}

object CaseInScala extends App {

  def setupLogging()= {
    import org.apache.log4j.{Level,Logger}
    val rootLogger = Logger.getLogger("org")
    rootLogger.setLevel(Level.ERROR)
  }

  setupLogging()

  val spark = SparkSession.builder()
    .appName("case test")
    .master("local[*]")
    .getOrCreate()

  import spark.sqlContext.implicits._
  val data = List(("James","","Smith","36636","M",60000),
    ("Michael","Rose","","40288","M",70000),
    ("Robert","","Williams","42114","",400000),
    ("Maria","Anne","Jones","39192","F",500000),
    ("Jen","Mary","Brown","","F",0))

  val cols = Seq("first_name","middle_name","last_name","dob","gender","salary")

  val df = spark.createDataFrame(data).toDF(cols:_*)

  df.show(false)

  val df2 = df.select(col("*"),when(col("gender") === "M","Male")
    .when(col("gender") === "F","Female")
    .otherwise("Unknown")).show(false)

  val df3 = df.withColumn("new_gender",
    expr("case when gender = 'M' then 'Male' " + "when gender = 'F' then 'Female' " +
    "else 'Unknown2' end")).groupBy("gender").sum("salary").show(false)
}
