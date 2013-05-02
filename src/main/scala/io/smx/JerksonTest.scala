package io.smx

/**
 * Company: Socialmetrix
 * User: arjones
 * Date: 5/1/13
 * Time: 10:45 PM
 *
 *
 */
object JerksonTest {

  import Data._
  import com.codahale.jerkson.Json._

  // Serialize
  val actualStr = generate(me)
  assert(actualStr == meStr)


  val actual = parse[People](meStr)
  assert(actual == me)
}

object JerksonTest2 {

  import Data._

  val ju = new JerksonJsonUtil[People]

  // Serialize
  val actualStr = ju.toJson(me)
  assert(actualStr == meStr)


  val actual = ju.fromJson(meStr)
  assert(actual == me)
}

class JerksonJsonUtil[T] {

  import com.codahale.jerkson.Json._

  def toJson(o: T) = generate(o)

  def fromJson(str: String)(implicit mf: Manifest[T]): T = parse[T](str)
}
