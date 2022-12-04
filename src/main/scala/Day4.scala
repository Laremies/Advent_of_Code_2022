import scala.io.Source

object Pairs extends App {
  val input = Source.fromFile("inputs/pairs.txt")
  val pairs = input.getLines

  var containments = 0
  var overlaps = 0
  while (pairs.hasNext) {
    val pair = pairs.next.split(",")
    val assignments = pair.flatMap(_.split("-")).map(_.toInt)
    if (assignments(0) <= assignments(2) && assignments(1) >= assignments(3) ||
        assignments(0) >= assignments(2) && assignments(1) <= assignments(3)) {
      containments += 1
    }
    if (!(assignments(0) > assignments(3) || assignments(1) < assignments(2))) {
      overlaps += 1
    }
  }
  input.close

  println("In " + containments + " assignment pairs, an assignment fully contains another assignment.")
  println("In " + overlaps + " assignment pairs, an assignment overlaps another assignment.")
}
