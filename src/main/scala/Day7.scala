import scala.collection.mutable
import scala.io.Source

object FileTree extends App {
  val input = Source.fromFile("inputs/dirs.txt")
  val commands = input.getLines
  val path = mutable.Stack[String]()
  val dirs = mutable.Map[String, Long]()

  while (commands.hasNext) {
    val command = commands.next.split(" ")
    if (command(1) == "cd") {
      if (command(2) == "..") path.pop
      else {
        path.push(command(2))
        dirs += command(2) -> 0
      }
    } else if (command.head.forall(_.isDigit)) {
      path.foreach(dir => dirs(dir) += command.head.toLong)
    }
  }

  input.close
  println(dirs.mkString("\n"))
  println(dirs.values.filter(_ <= 100000).sum)
}
