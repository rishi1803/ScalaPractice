def addOptions (a: Option[Int], b: Option[Int]) = {
  for {
    x <- a
    y <- b
  } yield x + y
}
def addOptions1 (a: Option[Int],b: Option[Int]) = {
  a.flatMap(x => b map(y => x+ y))
}

def addOptions(opt1: Option[Int], opt2 :Option[Int],opt3 : Option[Int] ) = {
  for {
    x <- opt1
    y <- opt2
    z <- opt3
  } yield  x+ y + z
}

def addOptions1(a: Option[Int],b: Option[Int],c: Option[Int]) = {
  a.flatMap(x => b flatMap(y => c map(z => x + y + z)))
}

def divide(a: Int, b: Int) = {
 if (b == 0) None else Some(a/b)
}

def divideOption(numerator: Option[Int], denominator: Option[Int]): Unit = {
  for {
    x <- numerator
    y <- denominator
    z <- divide(x,y)
  } yield println(z)
}

def readInt(str: String): Option[Int] =
  if(str matches "-?\\d+") Some(str.toInt) else None

def calculator(operand1: String,operator :String, operand2: String) = {

  val result = for {
    a <- readInt(operand1)
    b <- readInt(operand2)
    ans <- operator match {
      case "+" => Some(a + b)
      case "-" => Some(a - b)
      case "*" => Some(a * b)
      case "/" => divide(a , b)
      case _ => None
    }
  } yield ans

  result match {
    case Some(number) => println(s"The answer is $number!")
    case None => println(s"Error calculating $operand1 $operator $operand2")
  }
}

calculator("3", "/" ,"2")


//For comprehension Redux
for {
  x <- Seq(-2,-1,0,1,2) if x >0
} yield x


// zip
for {
  x <- Seq(1,2,3).zip(Seq(4,5,6))
} yield {val (a,b) = x; a + b}

// zipWithIndex

for {
  x <- Seq(1,2,3).zipWithIndex
} yield x

// write zip as a pattern Matching
for {
  (a,b) <- Seq(1,2,3).zip(Seq(4,5,6))
} yield a+b

//Intermediate Result

for {
  x <- Seq(1,2,3)
  square = x * x
  y <- Seq(4,5,6)
} yield square * y

//Maps and Sets

val example = Map("a" -> 1, "b" -> 2, "c" -> 3)

//Returns value of the Key
example("a")

//returns Option
example.get("a")

example.getOrElse("d",-1)

example.contains("d")

example.size

example.+("c" -> 10, "d" -> 11, "e" -> 12)

example.-("c","d")

//ListMap for ordered Collection



