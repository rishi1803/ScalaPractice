package com.problemSolving

object MinMax extends App {

  val arr: Array[Int] = Array(0, -1, 8, 8, 8)

  def maxMinSum(arr: Array[Int]) = {
    val len = arr.length
    val sortArray = arr.sorted
    var sum:Long = 0
    for( i <- arr){
      sum += i
    }

    val arrSum = sum

    val maxSum = arrSum - sortArray(0)
    val minSum = arrSum - sortArray(len-1)

    println(minSum + " " + maxSum)
    println ((arr.sum - arr.max) + " " + (arr.sum - arr.min))
  }

  maxMinSum(arr)
}
