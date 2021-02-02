package MyselfAndI

import scalafx.scene.canvas.Canvas
import helpers._

class PipeCanvas() extends Canvas {

  private val gapSize = 250
  private val GC = graphicsContext2D
  private var pipes: List[Pipe] = List(Pipe(800,0, 100, generateUpperY()))
  private var x: Double = 800

  def clear(): Unit = {
    pipes.foreach(pipe => {
      GC.clearRect(pipe.x, pipe.y, pipe.width, pipe.height)
      GC.clearRect(pipe.x, pipe.height + gapSize, pipe.width, 600 - (pipe.y + gapSize))
    })
  }

  def drawPipes(): Unit = {
    pipes.foreach(pipe => {
      GC.fillRect(pipe.x, pipe.y, pipe.width, pipe.height)
      GC.fillRect(pipe.x, pipe.height + gapSize, pipe.width, 600 - (pipe.height + gapSize))
    })
  }

  def addPipes(): Unit = {
    pipes = Pipe(800, 0, 100, generateUpperY()) :: pipes
  }

  def increaseX(): Unit = {
    x -= 1
    if (x % 200 == 0) {
      addPipes()
    }
    pipes = pipes.map(pipe => {
      Pipe(pipe.x-1, pipe.y, pipe.width, pipe.height)
    })
  }

  def draw(): Unit = {
    clear()
    increaseX()
    drawPipes()
  }

}
