package example.diode.store

import diode.Circuit
import example.diode.store.CounterStore.{ CounterHandler, CounterState }
case class AppModel(counter: CounterState)

object AppCircuit extends Circuit[AppModel] {
  def initialModel = AppModel(
    CounterStore.initialState
  )

  override val actionHandler: HandlerFunction = foldHandlers(new CounterHandler)
}
