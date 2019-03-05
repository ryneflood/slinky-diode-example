package example.diode

import diode.Circuit
import example.diode.store.{AppCircuit, AppModel}
import slinky.core._
import slinky.core.annotations.react
import slinky.core.facade.React
import slinky.web.html._

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSImport, ScalaJSDefined}

@JSImport("resources/App.css", JSImport.Default)
@js.native
object AppCSS extends js.Object

@JSImport("resources/logo.svg", JSImport.Default)
@js.native
object ReactLogo extends js.Object

@react class App extends StatelessComponent {
  type Props = Unit

  private val css = AppCSS

  def render() = {
    App.diodeContext.Provider(AppCircuit)(
      div(className := "App")(
        header(className := "App-header")(
          img(src := ReactLogo.asInstanceOf[String], className := "App-logo", alt := "logo"),
          h1(className := "App-title")("Welcome to React (with Scala.js!)")
        ),
        Counter()
      )
    )
  }
}

object App {
  val diodeContext = React.createContext[Circuit[AppModel]](AppCircuit)
}