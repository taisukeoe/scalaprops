package scalaprops

import scalaz._
import scalaz.std.anyVal._

object TheseTest extends Scalaprops {

  private type F[A] = Int \&/ A

  val test0 =
    Properties.list(
      scalazlaws.equal.all[Int \&/ Int],
      scalazlaws.semigroup.all[Int \&/ Int]
    )

  val test1 =
    Properties.list(
      scalazlaws.monad.all[F],
      scalazlaws.cobind.all[F],
      scalazlaws.traverse.all[F]
    )

  val test2 =
    scalazlaws.bitraverse.all[\&/]
}
