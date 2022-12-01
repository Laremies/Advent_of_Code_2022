import scala.io.Source
import scala.collection.mutable._

object Calorie extends App {
  val calories = Source.fromFile("calories.txt")
  var elfs = Map[Int, Int]()
  var elf = 0

  for (line <- calories.getLines) {
    if (line.nonEmpty) {
      if (elfs.contains(elf)) {
        elfs(elf) += line.toInt
      } else {
        elfs(elf) = line.toInt
      }
    } else {
      elf += 1
    }
  }

  calories.close

  println("PART 1")
  println(elfs.values.max)
  println("PART 2")
  println(elfs.values.toBuffer.sorted.takeRight(3).sum)
}
