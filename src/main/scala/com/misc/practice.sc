import org.apache.spark.sql._

Row.merge(Row(1),Row("hello"))

object Test7 {
  val simpleField = {
    println("Evaluating simpleField")
    42
  }
  def noParameterMethod = {
    println("Evaluating noParameterMethod")
    42
  }
}

Test7.simpleField

Test7.simpleField

Test7.noParameterMethod

Test7.noParameterMethod



object argh {
  def a = {
    println("a")
    1
  }
  val b = {
    println("b")
    a + 2
  }
  def c = {
    println("c")
//    aa
    b + "c"
  }
}

argh.c + argh.b + argh.a





