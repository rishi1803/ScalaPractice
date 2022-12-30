package com.olc

import org.apache.commons.collections.CollectionUtils
import org.apache.commons.lang.StringUtils

import scala.collection.mutable.{ArrayBuffer, ListBuffer}

object UtilsCheck {

  def add(n: ArrayBuffer[Int]):Int={

    n += 15;
    n.sum
  }

  def main(args: Array[String]): Unit = {
//    StringUtils
//    CollectionUtils
    val list = ArrayBuffer(1,2,3)
    val result = add(list)
    println(result)
  }
}
