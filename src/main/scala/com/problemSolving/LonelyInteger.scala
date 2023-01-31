package com.problemSolving

object LonelyInteger extends App {

  val arr = Array(1,2,1,3,2,3,5)


  for (i <- 0 until arr.length) {
    if (arr.indexOf(arr(i)) == arr.lastIndexOf(arr(i)) ) println(arr(i))
  }

}
