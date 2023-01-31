package com.problemSolving

object TimeConversion extends App {

val time = "12:05:45AM"

  val arr = time.split(":")
  arr.foreach(println)

  var hour = arr(0)
  val indicator = arr(2)
  var newTime= ""

  if (indicator.contains("PM")) {
    if (hour.toInt < 12) {
      hour = (arr(0).toInt + 12).toString
    } else if (hour.toInt == 12) {
      hour = "12"
    }
    newTime = hour +":"+arr(1)+":"+indicator.substring(0,2)
  } else {
    if (hour.toInt == 12) {
      hour = "00"
    }
    newTime = hour +":"+arr(1)+":"+indicator.substring(0,2)
  }

  println(newTime)
}
