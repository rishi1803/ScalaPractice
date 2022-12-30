package com.olc

object MakeString extends App {

  implicit class StringUtils(s:String) {
    def plusOne = s.map(c => (c + 1).toChar)

//    def age(format: String) = s match {
//      case  =>
//    }
  }

  val str = "ABCD".plusOne
  println(str)
}


