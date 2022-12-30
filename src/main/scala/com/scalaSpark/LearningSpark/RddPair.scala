package com.scalaSpark.LearningSpark

import org.apache.log4j.{Level, Logger}
import org.apache.spark.SparkContext

/**
 * Created by Rishabh on 21,May,2020
 */
object RddPair {

  def main(args: Array[String]): Unit = {

    Logger.getLogger("org").setLevel(Level.ERROR);
    val spark = new SparkContext("local[*]","RddPair")
    val rdd1 = spark.parallelize(Seq((1,2),(3,4),(3,6)))
    val rdd2 = spark.parallelize(Seq((3,9)))
    val subtract = rdd1.subtractByKey(rdd2)
    val testRdd = spark.parallelize(Seq(1,2,3,3))

    //check the number of partitions in a RDD
//    println(testRdd.partitions.size)
    val agg = testRdd.aggregate((0,0))((x,y) => (x._1+ y , x._2 + 1), (x,y) => (x._1 +y._1 , x._2+ y._2))
    val result = subtract.collect()

//    val com = rdd1.combineByKey(agg,rdd2)
    println(agg);


//    result.foreach(println);
  }
}
