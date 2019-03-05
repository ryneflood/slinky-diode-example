package example.diode

import slinky.web.html._
import example.diode.hooks.Diode.useDiode
import example.diode.store.AppCircuit
import example.diode.store.CounterStore.{Decrement, Increment, Reset}
import slinky.core.facade.Fragment

object Counter {
  val component = FunctionalComponent[Unit] { _ =>
    val (counterState, dispatch) = useDiode(App.diodeContext, AppCircuit.zoomTo(_.counter))

    div(
      p(s"Count is ${counterState.count}"),
      div(Fragment(
       button(onClick := (_ => dispatch(Increment)))("Increment"),
       button(onClick := (_ => dispatch(Decrement)))("Decrement"),
       button(onClick := (_ => dispatch(Reset)))("Reset")
      ))
    )
  }

  def apply() = component()
}
