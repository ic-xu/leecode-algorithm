package com.xu.algorithm

import java.util
import scala.util.control.Breaks.break

/**
 * @author chenxu
 * @date $date$ $time$
 * @version 1
 */

object CVTE校招2 {


  def main(args: Array[String]): Unit = {
    val clothes = Array(900, 800, 1000);
    val shoes = Array(500, 300, 250)
    val x = 1250
    val i = Main.purchasePlanNumber(clothes, shoes, x)
    println(i)
  }


//  def purchasePlanNumber(clothes: Array[Int], shoes: Array[Int], x: Int): Int = {
//    util.Arrays.sort(clothes)
//    util.Arrays.sort(shoes)
//    val slen = shoes.length
//    val clen = clothes.length
//    var i = 0
//    var j = slen - 1
//    var ans = 0
//    while (i < clen && j >= 0)
//      if (clothes(i) + shoes(j) > x)
//        j -= 1
//      else {
//        ans = ans + j + 1
//        i += 1
//      }
//    ans
//  }



}
