package com.DSAUdemy

object TwoDArray extends App {

  val tDArray = Array.ofDim[Int](3,3)

  tDArray(0)(0) = 1
  tDArray(0)(1) = 2
  tDArray(0)(2) = 2
  tDArray(1)(0) = 3
  tDArray(1)(1) = 4
  tDArray(1)(2) = 5
  tDArray(2)(0) = 1
  tDArray(2)(1) = 4
  tDArray(2)(2) = 3

  for (i <-0 to 2) {
    for (j <- 0 to 2) {
      print(tDArray(i)(j) + "\t")
    }
    println("\n")
  }

}
