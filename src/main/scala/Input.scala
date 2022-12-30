package com

object Input {
  def main(args: Array[String]): Unit = {
    val input = Seq (Map ("A" -> "a1", "B" -> "b1", "C" -> "c1", "D" -> "d1"), Map ("A" -> "a2", "B" -> "b2", "C" -> "c2", "D" -> "d2") )
    val input1 = input flatMap (_.toList) groupBy(_._1) mapValues(_.map(_._2))
    println(input)
    println(input1)
  }
}
