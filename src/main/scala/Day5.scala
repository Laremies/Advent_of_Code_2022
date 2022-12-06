import scala.collection.mutable._
import scala.io.Source

object Crane extends App {
  val input = Source.fromFile("inputs/moves.txt")
  val moves = input.getLines
  val stacks = ArrayBuffer[Stack[Char]](Stack('V', 'C', 'W', 'L', 'R', 'M', 'F', 'Q'),
                                        Stack('L', 'Q', 'D'),
                                        Stack('B', 'N', 'C', 'W', 'G', 'R', 'S', 'P'),
                                        Stack('G', 'Q', 'B', 'H', 'D', 'C', 'L'),
                                        Stack('S', 'Z', 'F', 'L', 'G', 'V'),
                                        Stack('P', 'N', 'G', 'D'),
                                        Stack('W', 'C', 'F', 'V', 'P', 'Z', 'D'),
                                        Stack('S', 'M', 'D', 'P', 'C'),
                                        Stack('C', 'P', 'M', 'V', 'T', 'W', 'N', 'Z'))
  val stacks2 = ArrayBuffer[Stack[Char]](Stack('V', 'C', 'W', 'L', 'R', 'M', 'F', 'Q'),
    Stack('L', 'Q', 'D'),
    Stack('B', 'N', 'C', 'W', 'G', 'R', 'S', 'P'),
    Stack('G', 'Q', 'B', 'H', 'D', 'C', 'L'),
    Stack('S', 'Z', 'F', 'L', 'G', 'V'),
    Stack('P', 'N', 'G', 'D'),
    Stack('W', 'C', 'F', 'V', 'P', 'Z', 'D'),
    Stack('S', 'M', 'D', 'P', 'C'),
    Stack('C', 'P', 'M', 'V', 'T', 'W', 'N', 'Z'))

  while (moves.hasNext) {
    val move = moves.next
    val instructions = move.split(" ")
    val amount = instructions(1).toInt
    val from = instructions(3).toInt - 1
    val to = instructions(5).toInt - 1
    val takeMultiple = stacks2(from).take(amount)
    for (i <- 0 until  amount) {
      val take = stacks(from).pop
      stacks2(from).pop
      stacks(to).push(take)
    }
    stacks2(to) = takeMultiple ++ stacks2(to)
  }
  input.close

  println("CrateMover 9000: " + stacks.map(_.top).mkString)
  println("CrateMover 90001: " + stacks2.map(_.top).mkString)
}
