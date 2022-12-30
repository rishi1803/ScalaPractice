package p {
  class Super {
    protected def f() = { println("f") }
  }
  class Sub extends Super {
    f()

  }
  //class Other {
  //  (new Super).f() // error: f is not accessible
  //}

}

// val output = Map("A"=> List("a1","a2"),"B"=> List("b1","b2"),"C"=> List("c1","c2"),"D"=> List("d1","d2")





