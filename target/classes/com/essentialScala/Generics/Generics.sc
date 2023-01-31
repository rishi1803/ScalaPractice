import scala.annotation.tailrec

sealed trait Result[T]
case class Success[T](result: T) extends Result[T]
case class Failure[T](reason:String) extends Result[T]

sealed trait LinkedList[T]{
  def length: Int =
    this match {
      case End() => 0
      case Pair(hd, tl) => 1 + tl.length
    }

  @tailrec
  def contains(value:T): Boolean =
    this match {
      case Pair(hd,tl) =>
        if(hd == value)
          true
        else
          tl.contains(value)
      case End() => false
    }

  def apply(pos :Int) : Result[T] =
    this match {
      case Pair(head, tail) =>
        if (pos == 0)
          Success(head)
        else
          tail.apply(pos - 1)
      case End() =>
        Failure("This is an empty list")
    }
}

final case class End[T]() extends LinkedList[T]

final case class Pair[T](head:T,tail:LinkedList[T]) extends LinkedList[T]



