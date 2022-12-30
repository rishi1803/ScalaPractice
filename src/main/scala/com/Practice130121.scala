package com

/**
 * @author : Rishabh
 * @since : 13-01-2021, Wed
 * */
object Practice130121 extends Logging with App {

  val arg = Array("--name=","--age=29")

  arg.foreach(logDebug(_))

  val keys = Seq("name","address","age","city")
  val comb = keys.map(x => x -> {
    val z = s"--$x="
    (arg.find(y=> y.contains(z)).map(_.replace(z,"")))
  }).filter(x=> x._2.isDefined && x._2.get.nonEmpty).map(x=> x._1 -> x._2).toMap
  println(comb)

}
