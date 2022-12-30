package com.ROCKTHEJVM

import scala.concurrent.Future
import scala.util.Try

/**
 *
 */
object NiceThingsCBN {

  def byValueFunction(x: Int) = 43
  byValueFunction(2+ 3) //2 + 3 = 5, you call byValueFunction(5)

  def byNameFunction(x: => Int) = x + 5
  byNameFunction(2 + 3) // 2 + 3 is passed LITERALLY

  //trick #1 reEvaluation
  def byValuePrint(x: Long) = {
    println(x)
    println(x)
  }

  def byNamePrint(x: => Long) = {
    println(x)
    println(x)
  }

  // trick # 2 call by need
  abstract class MyList[+T] {
    def head: T
    def tail: MyList[T]
  }

  //infinite collections: LazyList
  class NonEmptyList[+T](h: => T, t: => MyList[T]) extends MyList[T] {
    override lazy val head = h
    override lazy val tail = t
  }

  // trick #3 - hold the door
  val anAttempt: Try[Int] = Try { // seem like part of the language
    throw new NullPointerException
  }

  import scala.concurrent.ExecutionContext.Implicits.global
  val aFuture = Future {
    // hard computation for another thread
    42
  }

  def main(args: Array[String]): Unit = {
    byValuePrint(System.nanoTime())
    byNamePrint(System.nanoTime())
  }
}
