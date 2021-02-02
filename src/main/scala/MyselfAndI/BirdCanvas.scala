package MyselfAndI


import scalafx.scene.input.MouseEvent.MouseClicked
import scalafx.Includes._
import scalafx.scene.canvas.Canvas
import scalafx.scene.input.MouseEvent
import scalafx.scene.paint.Color

class BirdCanvas(color: Color, scale: Int, delta_time: Float) extends Canvas {

  private val h = 10
  private val w = 10
  private val GC = graphicsContext2D
  private var X: Float = 0.0f
  private var Y: Float = 200.0f
  private val dt: Float = delta_time
  private val force: Float = 10.0f
  private val mass: Float = 1.0f
  private val acceleration: Float = force/mass
  private var velocity: Float = acceleration * dt
  private val max_velocity = 1000
  private val amp = 200
  private val jump_height = 650
  GC.fill = color

  def getX: Double = X
  def getY: Double = Y

  def setX(n: Float): Unit = X = n
  def setY(n: Float): Unit = Y = n

  def jump(): Unit = velocity = -jump_height

  def addVelocityX(): Unit = X += velocity * dt

  def increaseVelocity(): Unit = {
    if (velocity < max_velocity) {
      velocity += (acceleration * dt) * amp
    }
  }

  def drawBird(): Unit = GC.fillRect(Y, X, w * scale, h * scale)

  def clear(): Unit = GC.clearRect(Y, X, w * scale, h * scale)

  /**
   * Clears old bird, calculates and adds velocity, and draws new bird at new coordinates.
   */
  def draw(): Unit = {
    //println(s"velocity: " + velocity)
    clear()
    increaseVelocity()
    addVelocityX()
    drawBird()
  }

  handleEvent(MouseEvent.Any) {
    e: MouseEvent => e.eventType match {
      case MouseClicked =>
        jump()
      case _ => ()
    }
  }

}
