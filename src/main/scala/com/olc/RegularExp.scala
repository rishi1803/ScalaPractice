package com.olc

object RegularExp extends App {

  var msg = "Your age is 27, and salary is 5000"
  val numRegex ="[0-9]+".r
  val firstMatch = numRegex.findFirstIn(msg)
}
