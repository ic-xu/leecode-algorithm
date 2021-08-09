package com.xu.algorithm

class ListNode(var next: ListNode, var value: String) {
}

object ReverseList {

  def main(args: Array[String]): Unit = {
    val node4 = new ListNode(null, "4")
    val node3 = new ListNode(node4, "3")
    val node2 = new ListNode(node3, "2")
    val node1 = new ListNode(node2, "1")
    val node = reverse(node1)
    println(node)

  }

  def reverse(listNode: ListNode): ListNode = {
    if (null == listNode || null == listNode.next) return listNode
    val temp = reverse(listNode.next)
    listNode.next.next = listNode
    listNode.next = null
    temp
  }
}
