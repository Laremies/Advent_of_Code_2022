import scala.io.Source

object Rucksack extends App {
  val input = Source.fromFile("Inputs/rucksack.txt")
  val rucksacks = input.getLines
  val alphabet = ('a' to 'z').toVector
  val contents = alphabet ++ alphabet.map(_.toUpper)
  var sum = 0

  while(rucksacks.hasNext) {
    val rucksack = rucksacks.next
    val comparment1 = rucksack.take(rucksack.length / 2).distinct
    val comparment2 = rucksack.drop(rucksack.length / 2).distinct
    for (c <- comparment1) {
      if (comparment2.contains(c)) {
        sum += contents.indexOf(c) + 1
      }
    }
  }
  input.close
  println(sum)
}
