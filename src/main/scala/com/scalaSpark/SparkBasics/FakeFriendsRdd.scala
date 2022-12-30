package com.scalaSpark.SparkBasics

import org.apache.log4j.{Level, Logger}
import org.apache.spark.{HashPartitioner, SparkContext}

/**
  * Created by Rishabh on 01,May,2020
  */
object FakeFriendsRdd {

  def main(args: Array[String]): Unit = {

    Logger.getLogger("org").setLevel(Level.ERROR)
    val sc = new SparkContext("local[*]","FakeFriend")
//    val startTime = System.currentTimeMillis()
//    println(startTime)
    val friendList = sc.textFile("C:\\Users\\SUNNY\\Desktop\\SCALA\\SparkScala\\fakefriends.csv")

    def parseLine(line: String) = {
      val fields = line.split(",")
      val age = fields(2).toInt
      val friends = fields(3).toInt
      (age,friends)
    }

    val rdd = friendList.map(parseLine)
//    val com = rdd.combineByKey(v => (v,1),(acc:(Int,Int),v) => (acc._1 + v,acc._2 + 1),
//      (acc1:(Int,Int),acc2:(Int,Int)) => (acc1._1 + acc2._1 ,acc1._2 + acc2._2))
//      .map{ case (key, value) => (key, value._1 / value._2.toFloat) }
//    com.collectAsMap().map(println(_))
//    rdd.reduceByKey((x,y) => (x._1 + y._1 , x._2 + y._2))
    val totalFriendsByAge = rdd.mapValues(x => (x,1)).reduceByKey((x,y) => (x._1 + y._1 ,x._2 + y._2))//.partitionBy(new HashPartitioner(10)).persist()
//    println(totalFriendsByAge.partitioner)
    val avgFriendByAge = totalFriendsByAge.mapValues(x => x._1 /x._2)
    val results = avgFriendByAge.collect()
    results.sorted.foreach(println)
//    val stopTime = System.currentTimeMillis()
//    println(stopTime)
//    println("Total Time:" + (stopTime - startTime)/1000)
  }
}
