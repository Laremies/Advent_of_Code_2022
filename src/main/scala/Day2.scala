import scala.io.Source

object RockPaperScissors extends App {
  val input = Source.fromFile("Inputs/rounds.txt")
  val rounds = input.getLines
  val DRAW = 3
  val WIN = 6
  val points = Map[String, Int]("A" -> 1, "B" -> 2, "C" -> 3,
                                "X" -> 1, "Y" -> 2, "Z" -> 3)
  //win conditions
  val win = Map[String, String]("A" -> "Y", "B" -> "Z", "C" -> "X")
  //lose conditions
  val lose = Map[String, String]("A" -> "Z", "B" -> "X", "C" -> "Y")

  //score for part 1
  var score1 = 0
  //score for part 2
  var score2 = 0

  while (rounds.hasNext) {
    val round =  rounds.next.split(" ")
    val opponent = round.head
    val me = round(1)

    //part 1 calculations
    score1 += points(me)
    if (points(me) == points(opponent)) score1 += DRAW
    if (win(opponent) == me) score1 += WIN

    //part 2 calculations
    me match {
      case "X" => score2 += points(lose(opponent))
      case "Y" => score2 += DRAW + points(opponent)
      case "Z" => score2 += WIN + points(win(opponent))
    }
  }
  input.close

  println("Part 1 score: " + score1)
  println("Part 2 score: " + score2)
}