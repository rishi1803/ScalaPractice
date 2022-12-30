"dog".permutations.toList
Seq(1,2,3).flatMap(x => Seq(x,x*10))

Seq(1,2,3).foldLeft(0)(_ + _)

def minimum(seq : Seq[Int]): Int={
  //seq.sortWith(_ < _).head
  seq.foldLeft(Int.MaxValue)(math.min)
}

//val seq = Seq(1,1,2,4,3,4)

def insert(seq : Seq[Int], elt: Int) : Seq[Int] = {
  if(seq.contains(elt))
    seq
  else
    elt +: seq
}

def unique(seq: Seq[Int]): Seq[Int] = {
  seq.foldLeft(Seq.empty[Int]){insert _ }
}

unique(Seq(1, 1, 2, 4, 3, 4))

def reverse[A](seq: Seq[A]): Seq[A] = {
  seq.foldLeft(Seq.empty[A]){(seq, elt) => elt +: seq}
}

reverse(Seq(2,3,4,5))

def map[A,B](seq: Seq[A],f: A => B) : Seq[B] ={
  seq.foldRight(Seq.empty[B]){(elt,seq)  => f(elt) +: seq}
}

