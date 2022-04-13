package com.xu.algorithm

import scala.util.control.Breaks
import scala.util.control.Breaks.breakable

/**
 * 题目
 * 请根据 CVTE 校招网每小时访客数量统计列表，重新生成一个访客递增指标列表。列表中值的含义为：
 * 以当前时间段（1小时）内访客数作对比，等待多少小时后访客数会增加。如果访客数量在这之后都不会增加，请在该位置用 0 来代替。
 * 提示：访客列表长度的范围是 [1, 10000]。每小时访客数量数值都是在 [0, 100] 范围内的整数。
 *
 * 样例输入：
 * [52, 54, 57, 41, 41, 66, 70, 73]
 * 样例输出：
 * [1, 1, 3, 2, 1, 1, 1, 0]
 *
 * 请实现下面的方法
 * public int[] indicators(int[] visitorCounts) {}
 *
 * @author chenxu
 * @version 1
 */
object CVTE校招1 {


  def main(args: Array[String]): Unit = {
    val ints = Array[Int](52, 54, 57, 41, 41, 66, 70, 73)
    Main.indicators(ints).foreach(x => println(x))
  }

  /**
   *
   * 解法一：暴力法，正向双重遍历
   *
   * @param array int[]
   * @return
   */
  def indicators1(array: Array[Int]): Array[Int] = {
    val intsArr = new Array[Int](array.length)
    for (i <- array.indices) {
      breakable {
        for (j <- i + 1 until array.length) {
          intsArr(i) = j - i
          if (array(i) < array(j)) {
            Breaks.break
          }
        }
      }
    }
    intsArr
  }

  /**
   *
   * 解法二：反向遍历
   *
   * @param array int[]
   * @return
   */
  def indicators2(array: Array[Int]): Array[Int] = {
    val intsArr = new Array[Int](array.length)
    for (i <- array.indices.reverse) {
      if (i == array.length - 1) intsArr(i) == 0
      else if (array(i) >= array(i + 1)) {
        intsArr(i) = intsArr(i + 1) + 1
      } else
        intsArr(i) = 1
    }
    intsArr
  }


  /**
   *
   * 解法三：维护单调栈
   *
   * @param array int[]
   * @return
   */

  def indicators3(visitorCounts: Array[Int]): Array[Int] = {
    val length = visitorCounts.length
    // res 为访客递增指标列表
    val res = new Array[Int](length)
    // 维护一个递减栈，该栈用于存储未找到访客递增指标的数值在 visitorCounts 中对应的坐标
    // 从栈底到栈顶的下标对应的访客列表中的访客数依次递减
    val stack = new java.util.LinkedList[Integer]
    // 正向遍历访客数量列表
    for (i <- 0 until length) {
      val count = visitorCounts(i)
      // 当前访客数大于栈顶访客数时，可得到栈顶坐标数值对应游客数值的增长指标
      while (!stack.isEmpty && count > visitorCounts(stack.peek)) {
        // 栈顶为前一个未得到增长指标值的访客数对应的下标
        val prevIndex = stack.pop
        // 得到其增长指标
        res(prevIndex) = i - prevIndex
      }
      // 将当前游客数对应下标值入栈，用于后续计算它的的增长指标
      stack.push(i)
    }
    res
  }


  def indicators(visitorCounts: Array[Int]): Array[Int] = {
    val n = visitorCounts.length
    val res = new Array[Int](n)
    for (i <- 0 until n) {
      var flag = false
      for (j <- i + 1 until n) {
        if (visitorCounts(j) > visitorCounts(i)) {
          res(i) = j - i
          flag = true
        }
      }
      if (!flag) res(i) = 0
    }
    res
  }
}
