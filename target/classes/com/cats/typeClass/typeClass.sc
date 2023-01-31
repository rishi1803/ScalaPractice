trait Printable[A] {
  def format(value: A): String
}

object PrintableInstances {
  implicit val stringPrintable = new Printable[String] {
    def format(value: String): String = value
  }

  implicit val intPrintable = new Printable[Int] {
    def format(value: Int): String = value.toString
  }
}

object Printable {
  def format[A](input:A) (implicit printable: Printable[A]): String = {
    printable.format(input)
  }

  def print[A](input:A)( implicit printable: Printable[A]) :Unit = {
    println(format(input))
  }
}
final case class Cat(name:String,age:Int,color:String)
import PrintableInstances._

implicit val catPrintable = new Printable[Cat] {
  def format(cat: Cat) = {
    val name = Printable.format(cat.name)
    val age = Printable.format(cat.age)
    val color = Printable.format(cat.color)
    s"$name is a $age year-old $color cat."
  }
}

import cats.Show
import cats.instances.int._ // for Show
import cats.instances.string._ // for Show
import cats.syntax.show._ // for show

implicit val catShow = Show.show[Cat] {cat =>
  val name = cat.name.show
  val age = cat.age.show
  val color = cat.color.show
  s"${name} is a ${age} year old ${color} cat"
}

println(Cat("Garfield", 38, "ginger and black").show)

import cats.syntax.semigroup._
1 |+| 2

import scala.concurrent.{Future,Await}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

val future:Future[String] =
  Future(123).map(n => n + 1)
    .map(n=> n * 2)
    .map(n => n + "!")

Await.result(future,1.second)