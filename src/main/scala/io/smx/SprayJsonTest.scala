package io.smx

import spray.json.JsonFormat


/**
 * Company: Socialmetrix
 * User: arjones
 * Date: 5/1/13
 * Time: 11:12 PM
 *
 *
 */

// All case-classes must be declared here BEFORE been used in `convertTo`
object MyJsonProtocol extends spray.json.DefaultJsonProtocol {

  import io.smx.Data.{People, Company}

  implicit val companyFmt = jsonFormat1(Company)
  implicit val peopleFmt = jsonFormat2(People)
}

object SprayJsonTest {
  import spray.json._

  import Data._

  val jsonAst = JsonParser(meStr)
  assert(jsonAst.compactPrint == meStr)


  import MyJsonProtocol._

  val actual = JsonParser(meStr).convertTo[People]
  assert(actual == me)
}

object SprayJsonTest2 {
  import Data._

  //  import MyJsonProtocol._
  import MyJsonProtocol._

  val ju = new SprayJsonUtil[People]
  val actualStr = ju.toJson(me)
  assert(actualStr == meStr)

  val actual = ju.fromJson(meStr)
  assert(me == actual)

}


class SprayJsonUtil[T: JsonFormat] {

  import spray.json._

  def toJson(o: T) = o.toJson.compactPrint

  def fromJson(str: String): T = JsonParser(str).convertTo[T]
}


