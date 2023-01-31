class Math(num:Int) {
  def square =num *num
}

val obj = new Math(5)
obj.square

import scala.language.implicitConversions
implicit def mySquare(num:Int) = new Math(num)

5.square

def isPrime(n:Int):Boolean = {
  def isPrimeTailRec(t:Int, isStillPrime:Boolean): Boolean =
    if (!isStillPrime) false
    else if(t<= 1) true
    else isPrimeTailRec(t-1,n %t != 0 && isStillPrime)

    isPrimeTailRec(n/2, true)
}

isPrime(11)

def fibonacci(n:Int): Int = {
  def fibonacciTailRec(t:Int, last: Int, nextToLast: Int): Int =
    if (t >= n) last
    else fibonacciTailRec(t+1, nextToLast+ last, last)

  if (n <= 2) 1
  else fibonacciTailRec(2, 1, 1)
}

println(fibonacci(8))


