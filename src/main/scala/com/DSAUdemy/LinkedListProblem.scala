package com.DSAUdemy

object LinkedListProblem extends App {

//  val a = List(1,2,3)
//  val head = a.head
//  val tail = a.tail
//
//  val b = List(head,tail)
//
//  b.foreach(println)

  val c = scala.collection.mutable.LinkedList(1,2,3,4,5,6)
  println(c.next)

//  var slowPtr = c.head
  val abc = c.length -2 -1
  val par = c(abc)

  println(c(abc))
//  def deleteKthElement(lst: scala.collection.mutable.LinkedList[Int], pos:Int) = {
//
//  }
//  }


}
