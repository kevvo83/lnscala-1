package com.investigate

object CurryTest extends App {

  // https://docs.scala-lang.org/tour/currying.html

  val test = 5 % 3
  println(s"${test}")


  // Is this an example of TAIL RECURSIVE FUNCTION, without the Compiler Optimization :-))))
  // Need to look some more and do examples
  def filter(xs: List[Int], p: Int => Boolean): List[Int] =
    if (xs.isEmpty) xs
    else if (p(xs.head)) xs.head :: filter(xs.tail, p)
    else filter(xs.tail, p)

  def modN(n: Int)(x: Int) = ((x % n) == 0)

  val nums = List(1, 2, 3, 4, 5, 6, 7, 8)
  println(filter(nums, modN(2)))
  //println(filter(nums, modN(3)))
}