package com.xu.algorithm;

/**
 * @author chenxu
 * @version 1
 * @date 2022/5/9 20:36
 */
public class L19 {


    /**
     * 两次循环
     *
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 39.2 MB
     * , 在所有 Java 提交中击败了
     * 91.49%
     * 的用户
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (null == head) {
            return null;
        }
        ListNode oldHead = head;
        int length = 1;
        while (null != head.next) {
            length++;
            head = head.next;
        }

        if (length == n) {
            return oldHead.next;
        }

        int bcn = 0;
        head = oldHead;
        while (null != head.next) {
            if (bcn + 1 == length - n) {
                head.next = head.next.next;
                return oldHead;
            } else {
                head = head.next;
                bcn++;
            }
        }
        return oldHead;
    }


    /*

    执行用时：
0 ms
, 在所有 Java 提交中击败了
100.00%
的用户
内存消耗：
39.6 MB
, 在所有 Java 提交中击败了
41.37%
的用户

一次循环
     */
    public ListNode removeNthFromEndPro(ListNode head, int n) {

        ListNode virNode = new ListNode(-1, head);
        ListNode reHeader = virNode;
        ListNode qVirNode = new ListNode(-1, head);
        int p = 0, q = 0;
        while (null != qVirNode) {
            if (p + n + 1 == q) {
                p++;
                q++;
                virNode = virNode.next;
            } else {
                q++;
            }
            qVirNode = qVirNode.next;
        }
        virNode.next = virNode.next.next;
        return reHeader.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));
//        ListNode listNode = new ListNode(1, new ListNode(2));
        ListNode listNode1 = new L19().removeNthFromEndPro(listNode, 2);

        System.out.println(listNode1.val);
    }


    static class ListNode {
        int val;
        L19.ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, L19.ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
