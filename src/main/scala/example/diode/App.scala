package example.diode

import diode.Circuit

import example.diode.store.{AppCircuit, AppModel}

import slinky.core._
import slinky.core.annotations.react
import slinky.core.facade.{React, ReactContext}
import slinky.web.html._

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

@JSImport("resources/App.css", JSImport.Default)
@js.native
object AppCSS extends js.Object

@JSImport("resources/logo.svg", JSImport.Default)
@js.native
object ReactLogo extends js.Object

@react object App {

  type Props = Unit

  private val css = AppCSS

  val diodeContext: ReactContext[Circuit[AppModel]] = React.createContext[Circuit[AppModel]](AppCircuit)

  val component: FunctionalComponent[Props] = FunctionalComponent[Props] { _ =>

    diodeContext.Provider(AppCircuit)(
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
