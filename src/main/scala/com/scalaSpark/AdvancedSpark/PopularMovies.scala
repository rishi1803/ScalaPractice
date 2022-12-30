package com.scalaSpark.AdvancedSpark

import java.nio.charset.CodingErrorAction

import org.apache.log4j.{Level, Logger}
import org.apache.spark.{SparkConf, SparkContext}

import scala.io.{Codec, Source}

/**
  * Created by Rishabh on 02,May,2020
  */
object PopularMovies {

  /**Load up a Map of movie IDs to movie names. */

  def loadMovieNames():Map[Int, String] ={

    //Handle character encoding issues:
    implicit val codec = Codec("UTF-8")
    codec.onMalformedInput(CodingErrorAction.REPLACE)
    codec.onUnmappableCharacter(CodingErrorAction.REPLACE)

    //Create a Map of Ints to Strings, and populate it from u.item
    var movieNames:Map[Int, String] = Map()

    val lines = Source.fromFile("C:\\Users\\SUNNY\\Desktop\\SCALA\\ml-100k\\u.item").getLines()
    for(line <- lines) {
      val fields = line.split('|')
      if (fields.length > 1) {
        movieNames += (fields(0).toInt -> fields(1))
      }
    }

    return movieNames
  }

  def main(args: Array[String]): Unit = {

    Logger.getLogger("org").setLevel(Level.ERROR)
//    val sparkConf = new SparkConf().setAppName("PopularMovies").setMaster("spark://vaio:7077").set("spark.submit.deployMode","cluster")

//    val sc = new SparkContext(sparkConf)
    val sc = new SparkContext("local[*]","PopularMovies")

    //create a broadcast  variable  of our ID -> movie name map
    var nameDict = sc.broadcast(loadMovieNames)

    val movieRatingData = sc.textFile("C:\\Users\\SUNNY\\Desktop\\SCALA\\ml-100k\\u.data")

    val moviesCount = movieRatingData.map(x => (x.split("\t")(1).toInt,1)).reduceByKey((x,y) => x+ y)

    val flipped = moviesCount.map(x => (x._2,x._1)).sortByKey()

    // Fold in the movie names from the broadcast variable
    val sortedMoviesWithNames = flipped.map(x=> (nameDict.value(x._2),x._1))

    val result = sortedMoviesWithNames.collect()

    result.foreach(println)

  }
}
