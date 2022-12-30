package com.olc

object ExtractNumber extends App {

  def getNumber(value: Int) = {
    if (value >= '0' && value <='9') value.toChar
    else ""
  }

  val input = "Hello4World23"
  val result = input.map(s=>getNumber(s)).mkString("").toInt
  println(result)
}
