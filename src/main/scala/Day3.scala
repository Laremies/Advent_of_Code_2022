import scala.collection.mutable._
import scala.io.Source

object Rucksack extends App {
  val input = Source.fromFile("Inputs/rucksack.txt")
  val rucksacks = input.getLines
  val alphabet = ('a' to 'z').toVector
  val contents = alphabet ++ alphabet.map(_.toUpper)

  // sum of priorities for part 1
  var sum = 0
  // groups of elves and sum for part 2
  val groups = Buffer[String]()
  var groupSum = 0
  var i = 0

  while(rucksacks.hasNext) {
    // part 1 calculations
    val rucksack = rucksacks.next
    val comparment1 = rucksack.take(rucksack.length / 2).distinct
    val comparment2 = rucksack.drop(rucksack.length / 2).distinct
    for (c <- comparment1) {
      if (comparment2.contains(c)) {
        sum += contents.indexOf(c) + 1
      }
    }

    // part 2 calculations
    i += 1
    groups += rucksack.distinct
    if (i == 3) {
      for (c <- groups(0)) {
        if (groups(1).contains(c) && groups(2).contains(c)) {
          groupSum += contents.indexOf(c) + 1
        }
      }
      groups.clear
      i = 0
    }
  }
  input.close

  println("Sum of priorities of duplicate items: " + sum)
  println("Sum of priorities of group badges: " + groupSum)
}
