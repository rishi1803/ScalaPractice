package com.DSAUdemy

import scala.collection.mutable.ArrayBuffer

object MaxArea extends App{

  val arr:Array[Int] = Array.fill[Int](10)(10)
//  arr(0) = 5
//  arr(1) = 6
//  arr.foreach(println)

  val containerArray = Array(1,8,5,4,7,8,7) // 6, 35, 32,8,7

  var maxArea = Integer.MIN_VALUE
//  println(maxArea)
  var begin = 0
  var end = containerArray.length -1
//  val width = end - begin
//  val height = Math.max(begin,end)
//  val area = width * height

  while (begin < end ) {
    val width = end - begin
    val height = Math.min(containerArray(begin),containerArray(end))
    val area = width * height
    println(s"width is: $width & height is $height & area is $area")
    maxArea = Math.max(maxArea,area)
    if(containerArray(begin) < containerArray(end)) {
      begin += 1
    } else {
      end -= 1
    }
  }

  println(maxArea)

}
