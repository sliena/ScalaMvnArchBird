package MyselfAndI

object Test extends App {

  println(System.currentTimeMillis())

  def generateUpperX() = {
    val start = 100
    val end   = 500
    val rnd = new scala.util.Random
    start + rnd.nextInt( (end - start) + 1 )
  }

  println(generateUpperX())

//  while (System.currentTimeMillis() + 5)

}
