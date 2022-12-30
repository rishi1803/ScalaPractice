package com.cats.typeClass

/**
 * @author : Rishabh
 * @since : 08-05-2021, Sat
 * */
final case class Cat(name:String,age:Int,color:String)

object test extends App {

  import com.cats.typeClass.PrintableInstances._

  implicit val catPrintable = new Printable[Cat] {
    def format(cat: Cat) = {
      val name = Printable.format(cat.name)
      val age = Printable.format(cat.age)
      val color = Printable.format(cat.color)
      s"$name is a $age year-old $color cat."
    }
  }

}

