package MyselfAndI

import scalafx.Includes._
import scalafx.animation.{KeyFrame, Timeline}
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.control.{Button, Label}
import scalafx.scene.input.MouseEvent
import scalafx.scene.input.MouseEvent.MouseClicked
import scalafx.scene.{Group, Scene}
import scalafx.scene.layout.{BorderPane, StackPane}
import scalafx.scene.paint.Color
import scalafx.scene.paint.Color.Red
import scalafx.scene.shape.Rectangle
import scalafx.util.Duration

object App extends JFXApp{

  val delta_time = 0.017f
  val stageWidth = 800
  val stageHeight = 600

  var timelineActive = false

  val bird = new BirdCanvas(Color.Red, 7, delta_time)
  val pipeCanvas = new PipeCanvas

  stage = new PrimaryStage {
    title = "Hello Stage"
    width = stageWidth
    height = stageHeight
    resizable = false

    scene = new Scene {

          private val timeline = new Timeline {
            cycleCount = Timeline.Indefinite
            keyFrames = KeyFrame(Duration(delta_time * 1000), onFinished = _ => {
              bird.draw()


              val seed = pipeCanvas.pipeCoords.map(p => helpers.Pipe(p._1, p._2))
              pipeCanvas.clear()
              val updated = helpers.update(seed)
              updated.foreach(pipe => pipeCanvas.drawPipes(pipe.x, pipe.y))


            })
          }

      def toggleTimeline(): Unit = {
        if (!timelineActive) {
          timeline.play()
          timelineActive = true
        }
      }

      handleEvent(MouseEvent.Any) {
        e: MouseEvent => e.eventType match {
          case MouseClicked =>
            toggleTimeline()
          case _ => ()
        }
      }

      content.add(pipeCanvas)
      pipeCanvas.width <== width
      pipeCanvas.height <== height

      content.add(bird)
      bird.width <== width
      bird.height <== height

    }
  }
}
