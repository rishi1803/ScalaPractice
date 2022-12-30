package com.DSAUdemy

object SpiralQues extends App {
  val tDArray = Array.ofDim[Int](4, 4)

  tDArray(0)(0) = 1
  tDArray(0)(1) = 2
  tDArray(0)(2) = 3
  tDArray(0)(3) = 4
  tDArray(1)(0) = 5
  tDArray(1)(1) = 6
  tDArray(1)(2) = 7
  tDArray(1)(3) = 8
  tDArray(2)(0) = 9
  tDArray(2)(1) = 10
  tDArray(2)(2) = 11
  tDArray(2)(3) = 12
  tDArray(3)(0) = 13
  tDArray(3)(1) = 14
  tDArray(3)(2) = 15
  tDArray(3)(3) = 16

  val arrT = Array(Array(1,2,3,4),Array(5,6,7,8),Array(9,10,11,12),Array(13,14,15,16))

//  for (i <- 0 to 3) {
//    for (j <- 0 to 3) {
//      print(arrT(i)(j) + "\t")
//    }
//    println("\n")
//  }
  var firstRow = 0
  var lastRow = arrT.length -1
  var firstCol = 0
  var lastCol = arrT(0).length - 1

  while (firstRow < lastRow && firstCol < lastCol) {

    //up
    for(i <- firstCol to lastCol) {
      println(arrT(firstRow)(i))
    }

    for(i <- firstRow+1 to lastRow) {
      println(arrT(i)(lastCol))
    }

    for(i <- lastCol-1 to firstCol by -1) {
      println(arrT(lastRow)(i))
    }

    for(i <- lastRow-1 to firstRow+1 by -1) {
      println(arrT(i)(firstCol))
    }

    firstRow += 1
    lastRow -= 1
    firstCol += 1
    lastCol -= 1
  }
}
