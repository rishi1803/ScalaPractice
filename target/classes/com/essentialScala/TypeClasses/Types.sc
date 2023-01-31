import intImplicit.IntOps

import scala.math.Ordering

val minOrdering = Ordering.fromLessThan[Int](_ < _)

val maxOrdering = Ordering.fromLessThan[Int](_ > _)

List(3,2,4).sorted(minOrdering)

import scala.math.abs
implicit val absMinOrdering = Ordering.fromLessThan[Int](abs(_) < abs(_))

List(-4, -1, 0, 2, 3).sorted

trait Equal[A] {
   def equal(val1: A, val2:A): Boolean
}

case class Person(name: String, email: String)

object EqualityByEmail extends Equal[Person] {
  def equal(v1: Person,v2:Person): Boolean = {
    v1.email == v2.email
  }
}


object EqualityByEmailAndName extends Equal[Person] {
  def equal(v1: Person,v2:Person): Boolean = {
    (v1.email == v2.email && v1.name == v2.name)
  }
}

object Eq {
  def apply[A] (v1:A, v2:A)(implicit equal :Equal[A]):Boolean=
    equal.equal(v1,v2)
}

//Eq(Person("Noel", "noel@example.com"), Person("Noel", "noel@ example.com"))

object intImplicit {
  implicit class IntOps(n: Int) {
    def yeah() =
      times(_ => println("Oh Yeah!"))
    def times(func: Int => Unit) =
      for {i <- 0 until n} func(i)
  }
}

2.yeah

-1.yeah
