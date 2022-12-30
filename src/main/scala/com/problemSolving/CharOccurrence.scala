package com.problemSolving

object  CharOccurrence extends App {

  val str = "aaabbaccdzz"
  var i = 0
  while (i < str.length -1) {
    var cnt = 1
     while (i+1 < str.length && str.charAt(i) == str.charAt(i+1) ) {
       i += 1
       cnt += 1
     }
    print(s"${str.charAt(i)}$cnt")
    i +=1
  }
}
