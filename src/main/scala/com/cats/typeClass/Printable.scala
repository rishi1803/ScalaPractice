package com.cats.typeClass

/**
 * @author : Rishabh
 * @since : 07-05-2021, Fri
 * */
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


