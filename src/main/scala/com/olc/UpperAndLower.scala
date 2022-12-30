package com.olc

object UpperAndLower extends App {


  def upperAndLower (str:Int) = {
    if (str >= 'a' && str <= 'z') (str - 32).toChar
    else if (str >= 'A' && str <= 'Z') (str + 32).toChar
  }

  val str = "HeLloWoRld".map(s=> upperAndLower(s)).mkString("")

  println(str)

}
