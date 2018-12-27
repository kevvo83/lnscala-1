object session {

  // Question1 - Pascal's Triangle - it's not Tail Recursive though
  def pascal(col:Int, row:Int): Int = {
    if (col==0 || col==row) 1
    else pascal(col, row-1) + pascal(col-1, row-1)
  }

  pascal(1,3)


  // Question 2 - check if a sentences parenthesis are closed properly
  def balance(chars: List[Char]):Boolean = {
    def loop(c: List[Char], state:Char = 'u', sumOpen:Int=0, sumClose:Int=0): Boolean={
      if (c.isEmpty) {
        if (sumOpen==sumClose && state=='c') true
        else false
      }
      else {
        val newState = c.head match {
          case ')' => 'c'
          case '(' => 'o'
          case _ => state
        }
        val nextSumOpen = c.head match {
          case '(' => sumOpen+1
          case _ => sumOpen
        }
        val nextSumClose = c.head match {
          case ')' => sumClose+1
          case _ => sumClose
        }
        loop(c.tail, newState, nextSumOpen, nextSumClose)
      }
    }
    loop(chars)
  }

  val test1 = "(if (zero? x) max (/ 1 x))".toList
  val test2 = "I told him (that it's not (yet) done). (But he wasn't listening)".toList
  val test3="())(".toList
  val test4=":-)".toList

  balance(test1)
  balance(test2)
  balance(test3)
  balance(test4)

  // Question 3
  def countChange(money: Int, coins: List[Int]): Int = {
    def loop(money:Int, denomConsider: Int, remDenoms: List[Int], numberOfWays:Int): Int={
      if (money==0 || money%denomConsider==0 || money<0) numberOfWays
      else {
        val newNumberOfWays:Int = if (money%denomConsider==0) numberOfWays+1 else numberOfWays
        if
      }
    }

  }
}