package io.smx

/**
 * Company: Socialmetrix
 * User: arjones
 * Date: 5/1/13
 * Time: 10:45 PM
 *
 *
 */
object Data {

  case class Company(name: String)

  case class People(name: String, company: Company)

  val meStr = """{"name":"arjones","company":{"name":"socialmetrix"}}"""

  val me = People("arjones", Company("socialmetrix"))
}
