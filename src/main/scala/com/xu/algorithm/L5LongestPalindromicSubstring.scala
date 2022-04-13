//package com.xu.algorithm
//
//
///**
// * 最大回文子串
// */
//class L5LongestPalindromicSubstring {
//
//  def longestPalindrome(s: String): String = {
//
//    if (s.trim.isEmpty) return ""
//    val dpTmp = Array.ofDim[Boolean](s.length, s.length)
//    for (i <- s.length to 0) {
//      for (j <- i to s.length) {
//        if (s.charAt(i) == s.charAt(j)) {
//          if (i - 1 >= j + 1) {
//            if (dpTmp(i + 1)(j - 1)) {
//              dpTmp(i)(j) = true
//            }
//          }else dpTmp(i)(j)=true
//        }
//        if(dpTmp(i)(j)){
//
//        }
//      }
//    }
//
//
//    ""
//  }
//
//}
//
//
//object L5LongestPalindromicSubstring {
//
//
//  def main(args: Array[String]): Unit = {
//    new L5LongestPalindromicSubstring().longestPalindrome("")
//  }
//
//}