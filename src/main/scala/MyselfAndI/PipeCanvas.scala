package MyselfAndI

import scalafx.scene.canvas.Canvas
import scalafx.scene.paint.Color

class PipeCanvas() extends Canvas {

  private val h = 100
  private var w = 100
  private val gapSize = 200
  private val GC = graphicsContext2D
  private var pipes: Set[(Double, Double)] = Set((800, helpers.generateUpperY()))

  def pipeCoords: Set[(Double, Double)] = pipes

  def clear(): Unit = {
    GC.clearRect(0, 0, width.value, height.value)
  }

  def drawPipes(x: Double, upperY: Double): Unit = {
    GC.fillRect(x, 0, 100, upperY)
    GC.fillRect(x, upperY + gapSize, 100, 600 - (upperY + gapSize))
    pipes += ((x, upperY))
  }

  def increaseX(): Unit = {
    w += 1
  }

  def draw(upperY: Double): Unit = {
    println(s"Y COORDS: $upperY")

//    clear(upperY)
    //clear(stageWidth - w, upperY + gapSize, 100, stageHeight)
    //GC2.clearRect(0, 0, 800, 600)
    //GC.fillRect(stageWidth - w, 0, 100, upperY)
    increaseX()
    //drawBottomPipe()
//    drawPipe(upperY)

  }



}
