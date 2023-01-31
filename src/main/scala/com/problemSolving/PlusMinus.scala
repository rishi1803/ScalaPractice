package com.problemSolving

import scala.reflect.internal.util.NoPosition.pos

object PlusMinus extends App {

  val arr = Array(4,-1,-2,0,3,-2)

  def percentageCount(arr: Array[Int]) = {
    val cnt = arr.length
    var pos = 0.0
    var neg = 0.0
    var zero = 0.0

    for( i <-0 until cnt) {
      if (arr(i) > 0) pos+=1
      else if (arr(i) < 0) neg += 1
      else zero+= 1
    }

    println(f"${pos/cnt}%.6f")
    println(f"${neg/cnt}%.6f")
    println(f"${zero/cnt}%.6f")
  }

  percentageCount(arr)

}
