import scala.io.Source

object Tuning extends App {
  val input = Source.fromFile("inputs/datastream.txt")
  val data = input.mkString
  val startOfPacket = data.sliding(4, 1).toList.filter(x => x.length == x.distinct.length).head
  val startOfMessage = data.sliding(14, 1).toList.filter(x => x.length == x.distinct.length).head

  println("Start of packet: " + data.indexOf(startOfPacket) + startOfPacket.length)
  println("Start of message: " + data.indexOf(startOfMessage) + startOfMessage.length)
}
