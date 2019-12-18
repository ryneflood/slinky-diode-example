package example.diode

import example.diode.hooks.Diode.useDiode
import example.diode.store.AppCircuit
import example.diode.store.CounterStore.{Decrement, Increment, Reset}

import slinky.core.FunctionalComponent
import slinky.core.annotations.react
import slinky.core.facade.Fragment
import slinky.web.html._

@react object Counter {

  type Props = Unit

  val component: FunctionalComponent[Unit] = FunctionalComponent[Unit] { _ =>
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

}
