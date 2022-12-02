import scala.io.Source

object RockPaperScissors extends App {
  val input = Source.fromFile("Inputs/rounds.txt")
  val rounds = input.getLines
  val points = Map[String, Int]("A" -> 1, "B" -> 2, "C" -> 3,
                                "X" -> 1, "Y" -> 2, "Z" -> 3)
  val wins = Map[String, String]("Y" -> "A", "Z" -> "B", "X" -> "C")

  var score = 0
  while (rounds.hasNext) {
    val round =  rounds.next.split(" ")
    val opponent = round.head
    val me = round(1)

    score += points(me)
    if (points(me) == points(opponent)) score += 3
    if (wins(me) == opponent) score += 6
  }
  input.close

  println(score)
}