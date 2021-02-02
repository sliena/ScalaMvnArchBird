package MyselfAndI

object helpers {

  case class Pipe(x: Double, y: Double, width: Double, height: Double)

  // generate Y coordinates for upper pipe
  def generateUpperY(): Double = {
    val start = 100
    val end   = 400
    val rnd = new scala.util.Random
    start + rnd.nextInt( (end - start) + 1 ).toDouble
  }
}
