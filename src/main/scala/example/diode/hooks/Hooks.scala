package example.diode.hooks

import slinky.core.facade.ReactContext

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

object Hooks {
  @JSImport("react", JSImport.Namespace)
  @js.native
  private object HooksAPI extends js.Object {
    def useState[T](default: T): js.Tuple2[T, js.Function1[T, Unit]] = js.native
    def useEffect(f: js.Function0[js.Function0[Unit]], depends: js.Array[Any]): Unit = js.native
    def useContext[T](context: ReactContext[T]): T = js.native
  }

  def useState[T](default: T): (T, T => Unit) = {
    val call = HooksAPI.useState(default)
    (call._1, call._2)
  }

  def useEffect(f: () => js.Function0[Unit], depends: Seq[Any] = Seq()): Unit = {
    import js.JSConverters._
    HooksAPI.useEffect(f, depends.toJSArray)
  }

  def useEffectFn0(f: () => Unit, depends: Seq[Any] = Seq()): Unit = {
    def wrappedFunction() = {
      f.apply()

      () =>
    }

    useEffect(wrappedFunction, depends)
  }

  def useContext[T](context: ReactContext[T]): T = {
    HooksAPI.useContext(context)
  }
}
