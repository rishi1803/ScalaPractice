import org.apache.hadoop.mapred.Counters.Counter

object Sum {
  def sum(a:Int, b: Int) = a+ b
}

Sum.sum _

object MathStuff {
  def add1(num: Int) = num + 1
}

Counter(2).adjust(MathStuff.add1)

def Tree[A](Node:(A,A) => A)(Leaf:A)

val tree: Tree[String] =
  Node(Node(Leaf("To"), Leaf("iterate")),
    Node(Node(Leaf("is"), Leaf("human,")),
      Node(Leaf("to"), Node(Leaf("recurse"), Leaf("divine")))))


//sealed trait Sum[A,B]
//final case class Left[A,B](value:A) extends Sum[A,B]
//final case class Right[A,B](value:B) extends Sum[A,B]

//sealed trait Maybe[A]
//final case class Full[A](value:A) extends Maybe[A]
//final case class Empty[A]() extends Maybe[A]

sealed trait Maybe[A] {
  def fold[B](full :A => B,empty: B) : B =
    this match {
      case Full(v) => full(v)
      case Empty() => empty
    }
}

final case class Full[A](value:A) extends Maybe[A]
final case class Empty[A]() extends Maybe[A]


sealed trait Sum[A,B] {
  def fold[C](left:A => C, right:B=> C) :C =
    this match {
      case Left(a) => left(a)
      case Right(b) => right(b)
    }
}
final case class Left[A,B](value:A) extends Sum[A,B]
final case class Right[A,B](value:B) extends Sum[A,B]

sealed trait LinkedList[A] {
  def map[B](fn: A=> B) : LinkedList[B] =
    this match {
      case Pair(hd, tl) => Pair(fn(hd),tl.map(fn))
      case End() => End[B]
    }
}

final case class Pair[A](hd:A,tl:LinkedList[A]) extends LinkedList[A]
final case class End[A]() extends LinkedList[A]


val list: LinkedList[Int] = Pair(1, Pair(2, Pair(3, End())))

list.map(_ * 2)

