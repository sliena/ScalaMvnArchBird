package MyselfAndI

object helpers {

  case class Pipe(x: Double, y: Double)

  // generate Y coordinates for upper pipe
  def generateUpperY(): Double = {
    val start = 100
    val end   = 400
    val rnd = new scala.util.Random
    start + rnd.nextInt( (end - start) + 1 ).toDouble
  }

  def update(pipes: Set[Pipe]): Set[Pipe] = {
    pipes.map(p => Pipe(p.x - 1, p.y))
  }

}
