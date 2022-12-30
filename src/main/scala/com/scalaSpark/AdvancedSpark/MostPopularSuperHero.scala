package com.scalaSpark.AdvancedSpark

import org.apache.log4j.{Level, Logger}
import org.apache.spark.SparkContext

/**
  * Created by Rishabh on 02,May,2020
  */
object MostPopularSuperHero {

  def countCoOccurences(line:String) = {
    val elements = line.split("\\s+")
    (elements(0).toInt, elements.length - 1)
  }

  def parseNames(line:String) :Option[(Int, String)] = {
    var fields = line.split('\"')
    if (fields.length > 1) {
      return Some(fields(0).trim.toInt,fields(1))
    }
    else None // flatmap will discard none results and extract some data
  }

  def main(args: Array[String]): Unit = {

    Logger.getLogger("org").setLevel(Level.ERROR)
    val sc = new SparkContext("local[*]","MostPopularSuperHero")

    //Buildup HeroID ->Hero Name
    val names = sc.textFile("C:\\Users\\SUNNY\\Desktop\\SCALA\\SparkScala\\Marvel-names.txt")
    val namesRDD = names.flatMap(parseNames)

    // superHero co appearances data
    val lines = sc.textFile("C:\\Users\\SUNNY\\Desktop\\SCALA\\SparkScala\\Marvel-graph.txt")

    //convert to HeroId , number of connections
    val pairing =lines.map(countCoOccurences)

    // combine entries that span more than one line
    val totalFriendsByCharacter = pairing.reduceByKey((x,y) => x + y)

    //changes to friendCount, HeroId
    val flipped = totalFriendsByCharacter.map(x => (x._2, x._1))

    // Hero with maximum friends
    val mostPopular = flipped.max()

    //find the name of teh Hero
    val mostPopularHeroName = namesRDD.lookup(mostPopular._2)(0)

    println(s"$mostPopularHeroName is the most popular SuperHero with ${mostPopular._1} co-appearances")

  }
}
