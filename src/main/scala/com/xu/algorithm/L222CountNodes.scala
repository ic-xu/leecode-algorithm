package com.xu.algorithm

import com.xu.algorithm.TreeNodeMaxMoney.TreeNode

object L222CountNodes {

  def main(args: Array[String]): Unit = {

  }

  def countNodes(root: TreeNode): Int = {

    recursion(root)
    ff(root)
  }


  def ff(root: TreeNode): Int = {
    if (null == root) {
      return 0
    }
    var level = 0;
    var tmp = root;
    while (tmp.left != null) {
      level += 1
      tmp = tmp.left
    }
    var min = 1 << level
    var max = 1 << (level + 1) - 1
    var mid = 0
    while (max > min) {
      mid = (max - min + 1) / 2 + min
      if (isExit(root, level, mid)) {
        min = mid
      } else max = mid - 1
    }
    mid
  }

  def isExit(root: TreeNode, level: Int, mid: Int): Boolean = {
    var bit = 1 << (level - 1) //去掉最高位
    var node: TreeNode = root
    while (node != null && bit > 0) {
      if ((bit & mid) == 0) {
        node = root.left
      } else node = root.right
      bit = bit >> 1
    }
    node != null
  }

  /**
   * 递归解法：挨着查找左右节点的孩子节点,深度遍历
   *
   * @param root 跟节点
   * @return
   */
  def recursion(root: TreeNode): Int = {
    if (root == null) 0 else countNodes(root.left) + countNodes(root.right) + 1
  }


}

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}