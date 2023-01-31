val sequence = Seq(1, 2, 3)

//sequence(3)

sequence.head

sequence.tail
sequence.tail.head

sequence.headOption
Seq().headOption
sequence.length
sequence.contains(2)
sequence.find(_ == 3)
sequence.find(_ > 4)
sequence.filter( _ > 1)
sequence.sortWith(_ > _)
sequence :+ (4)
0 +: sequence
sequence.+:(0)
sequence ++ Seq(4,5,6)
import scala.collection.immutable.Vector.apply
apply(1,2,3)

sequence :: 4 :: Nil
sequence.size
sequence.indices
sequence.apply(0)
sequence.mkString(",")
sequence.mkString("[",",","]")

val animals = Seq("cat","dog","penguin")
"mouse" +: animals :+ "tyrannosaurus"

2 +: animals

animals.filter(sequence.contains)