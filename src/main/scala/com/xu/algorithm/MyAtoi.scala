package com.xu.algorithm

import java.util.regex.Pattern

/**
 * 8. 字符串转换整数 (atoi)
 */
object MyAtoi {

  def main(args: Array[String]): Unit = {
    println(myAtoi("+"))
  }

  def myAtoi(s: String): Int = {
    if(s.trim.isEmpty||s.equals("-"))
      return 0
    var sub = ""
    val result: StringBuffer = new StringBuffer()
    val tmp = s.trim
    var arr = tmp.toCharArray
    if (tmp.startsWith("-")||tmp.startsWith("+")) {
      sub = tmp.substring(0,1)
      arr = tmp.substring(1).toCharArray
    } else {
      arr = tmp.toCharArray
    }
    for (i <- arr.indices) {
      if (!isNumber(arr(i).toString)) {
        if (result.toString.nonEmpty){
          val re =  BigInt.apply(sub + result.toString)
          if(re>Int.MaxValue)
            return Int.MaxValue;
          else if(re<Int.MinValue){
            return Int.MinValue
          }
          return re.intValue
        }
        else
          return 0
      } else result.append(arr(i))
    }
    if(result.toString.isEmpty){
      return 0
    }
    val re =  BigInt.apply(sub + result.toString)
    if(re>Int.MaxValue)
      return Int.MaxValue;
    else if(re<Int.MinValue){
      return Int.MinValue
    }
     re.intValue
  }


  /**
   * 判断一个字符串是否是数字。
   *
   * @param string
   * @return
   */
  def isNumber(string: String): Boolean = {
    if (string == null) return false
    val pattern = Pattern.compile("^-?\\d+(\\.\\d+)?$")
    pattern.matcher(string).matches
  }

}