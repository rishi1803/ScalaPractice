package com.cats.typeClass

sealed trait Json
final case class JsObject(get: Map[String,Json]) extends Json
final case class JsString(get:String) extends Json
final case class JsNumber(get: Int) extends Json
case object JsNull extends Json

trait JsonWriter[A] {
  def write(value: A) :Json
}
