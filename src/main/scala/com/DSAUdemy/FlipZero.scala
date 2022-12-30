package com.DSAUdemy

object FlipZero extends App {

   // 0 1 1 0 1 0 1 which zero to flip into one to get longest streak of 1

  val arr = Array(1,0,1,1,0,1,1,1,0,1,0,1)
  var arr2 = Array[Int]()
  var seqTotal = 0
  for( i <- 0 to arr.length-1) {
    if (arr(i) == 1) {
      seqTotal += 1
      if (seqTotal > 0 && i == arr.length-1) {
        arr2 = arr2 :+ seqTotal
      }
    } else {
      if (seqTotal > 0) {
        arr2 = arr2 :+ seqTotal
      }
      arr2 = arr2 :+ arr(i)
      seqTotal = 0
    }

  }
  arr2.foreach(println)

//  println(arr2.length)

  var maxSeq = 0
  for (i <- 0 to arr2.size-1 by 2) {
    var len = arr2(i)
    if ((i+1) < arr2.size) {
      len += 1
    }
    if ((i+2) < arr2.size) {
      len += arr2(i+2)
    }

    if(len > maxSeq) {
      maxSeq = len
    }

  }
  println("max seq length is: " + maxSeq)
}
