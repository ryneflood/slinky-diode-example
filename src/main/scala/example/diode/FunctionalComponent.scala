package example.diode

import slinky.core.facade.{React, ReactElement}

import scala.scalajs.js


class FunctionalComponent[P] private(fn: P => ReactElement) {
  private val component = ((obj: js.Object) => {
    fn(obj.asInstanceOf[js.Dynamic].__.asInstanceOf[P])
  }): js.Function1[js.Object, ReactElement]

  def apply(props: P): ReactElement = {
    React.createElement(component.asInstanceOf[js.Object], js.Dynamic.literal(
      __ = props.asInstanceOf[js.Any]
    ).asInstanceOf[js.Dictionary[js.Any]])
  }
}

object FunctionalComponent {
  def apply[P](fn: P => ReactElement) = new FunctionalComponent[P](fn)
}

