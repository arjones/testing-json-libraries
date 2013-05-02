package io.smx

import io.smx.Data._
import play.api.libs.json._

/**
 * Company: Socialmetrix
 * User: arjones
 * Date: 5/2/13
 * Time: 2:46 PM
 *
 *
 */

object PlayJsonTestReadsWrites {
  implicit val companyFmt = Json.format[Company]

  implicit val peopleFmt = Json.format[People]
}

object PlayJsonTest {

  import PlayJsonTestReadsWrites._

  val json: JsValue = Json.parse(meStr)
  val actual = json.as[People]

  assert(actual == me)


  val actualJsVal = Json.toJson[People](me)
  val actualStr = Json.stringify(actualJsVal)
  assert(actualStr == meStr)
}

object PlayJsonTest2 {

  import PlayJsonTestReadsWrites._

  val ju = new PlayJsonUtil[People]

  val actualStr = ju.toJson(me)
  assert(actualStr == meStr)

  val actual = ju.fromJson(meStr)
  assert(me == actual)
}


class PlayJsonUtil[T: Format] {

  import play.api.libs.json._

  def toJson(o: T): String = Json.stringify(Json.toJson[T](o))

  def fromJson(str: String): T = Json.parse(str).as[T]
}
