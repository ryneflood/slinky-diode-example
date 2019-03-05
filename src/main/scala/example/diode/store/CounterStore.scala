package example.diode.store

import diode._

object CounterStore {
  case class CounterState(count: Int)

  def initialState = CounterState(count = 0)

  case object Increment extends Action
  case object Decrement extends Action
  case object Reset extends Action

  class CounterHandler extends ActionHandler(AppCircuit.zoomTo(_.counter)) {
    override protected def handle = {
      case Increment => updated(value.copy(count = value.count + 1))
      case Decrement => updated(value.copy(count = value.count - 1))
      case Reset => updated(initialState)
    }
  }
}
