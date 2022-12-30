package com.essentialScala

object calc {

  def square (in: Double) = in * in

  assert(square(2.0) == 4.0)
  assert(square(3.0) == 9.0)
}