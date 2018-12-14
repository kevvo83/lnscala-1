import Math._

object session {

  // Newton Method for estimating Square Root - ref. Coursera Course by Martin Odersky
  def sqrtIter(x_input: Double, y_estimate: Double): Double = {

    def computeEstimate(x: Double, y: Double) : Double = ((x/y)+y)/2
    def isSatisfactoryResult(x: Double, est: Double): Boolean = if (abs((est*est)-x) < 0.001) true else false
    def isSatisfactoryResult2(x: Double, est: Double): Boolean = if (abs((est*est)-x) < (0.0005*x)) true else false

    if (isSatisfactoryResult2(x_input, y_estimate)) y_estimate
    else sqrtIter(x_input, computeEstimate(x_input, y_estimate))
  }

  sqrtIter(3,1)
  sqrtIter(3,20)
  sqrtIter(4,1)

  sqrtIter(0.001,1)
  sqrtIter(1.0e50,1)


  // Factorial Function Implementation that uses Tail Recursion
  def factorial(in_x: Double, prodsofar: Double = 1.0): Double = {
    if (in_x==0) prodsofar
    else factorial(in_x-1, prodsofar*in_x)
  }

  factorial(5)
  factorial(10)


  // Function that returns the Sum of Factorials of all Numbers between A and B.
  def sumFactorials(a: Double, b: Double, sum: Double = 0) : Double = {
    if (a>b) sum
    else sumFactorials(a+1, b, sum + factorial(a))
  }

  // Function that returns the Sum of Ints of all Numbers between A and B.
  def sumInts(a: Int, b: Int) = sum((x:Int)=>x,a,b)
  def sum(f:x=>x, a: Int, b: Int)

  sumFactorials(1,5)
}