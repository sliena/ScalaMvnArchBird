package MyselfAndI

import scalafx.Includes._
import scalafx.animation.{KeyFrame, Timeline}
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.input.MouseEvent
import scalafx.scene.input.MouseEvent.MouseClicked
import scalafx.scene.Scene
import scalafx.scene.paint.Color
import scalafx.util.Duration

object App extends JFXApp {

  val delta_time = 0.017f
  val stageWidth = 800
  val stageHeight = 600

  var timelineActive = false

  val bird = new BirdCanvas(Color.Red, 7, delta_time)
  val pipes = new PipeCanvas

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
              pipes.draw()

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

      content.add(pipes)
      pipes.width <== width
      pipes.height <== height

      content.add(bird)
      bird.width <== width
      bird.height <== height

    }
  }
}
