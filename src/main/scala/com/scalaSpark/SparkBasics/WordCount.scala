package com.scalaSpark.SparkBasics

import org.apache.log4j.{Level, Logger}
import org.apache.spark.SparkContext

/**
  * Created by Rishabh on 02,May,2020
  */
object WordCount {

  def main(args: Array[String]): Unit = {

    Logger.getLogger("org").setLevel(Level.ERROR)
    val sc = new SparkContext("local[*]","WordCount")
    val readBook = sc.textFile("C:\\Users\\SUNNY\\Desktop\\SCALA\\SparkScala\\book.txt")
    // Split the words by space [but it has punctuation issue whih used to include with the words as they are before space]
//    val splitWords = readBook.flatMap(x => x.split(" "))

    // Add regular Expression to resolve the punctuation issues
    val splitWords = readBook.flatMap(x => x.split("\\W+"))

    val lowercaseWords = splitWords.map(x => x.toLowerCase)

    //this is expensive operation so used reduceByKey to replace below
    //val wordCount = lowercaseWords.countByValue()

    //count the occurrence of each word
    val wordCount = lowercaseWords.map(x=> (x,1)).reduceByKey((x,y) => x + y)

    //practice step
//val wordCountSorted = wordCount.filter(x => x._1 == "and" || x._1 == "business")

    //Flip (word,count) tuple to (count, word)  and sort them
    val wordCountSorted = wordCount.map(x =>(x._2,x._1)).sortByKey()

    // Print the results, flipping the (count, word) results to word: count as we go.
//    for (result <- wordCountSorted) {
//      val count = result._1
//      val word = result._2
//      println(s"$word: $count")
//    }
    val result = wordCountSorted.collect()
    result.foreach(println)
  }
}
