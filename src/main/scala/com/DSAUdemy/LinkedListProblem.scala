package com.DSAUdemy

object LinkedListProblem extends App {

  val a = List(1,2,3)
  val head = a.head
  val tail = a.tail
  val b = List(head,tail)

  b.foreach(println)

  val c = scala.collection.mutable.LinkedList(1,2)


}
