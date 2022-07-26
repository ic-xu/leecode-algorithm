package com.xu.algorithm;

/**
 * @author chenxu
 * @version 1
 * @date 2022/6/2 11:47
 */
public class L24 {


    public static void main(String[] args) {

        ListNode listNode = new ListNode(1 );
        ListNode listNode1 = new L24().swapPairs(listNode);
        System.out.println(listNode1);
    }

    public ListNode swapPairs(ListNode head) {
        ListNode previousNode = null, resultNode = null,result = null;
        while (null!=head){
            if(null == previousNode){
                previousNode = head;
                head = head.next;
            }else {
                previousNode.next = head.next;
                head.next = previousNode;

                if(null == resultNode){
                    resultNode = head;
                    result = resultNode;
                }else{
                    resultNode.next.next = head;
                    resultNode = head;
                }
                head = previousNode.next;
                previousNode = null;
            }
        }
        if(null == result){
            return previousNode;
        }
        return result;
    }



    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}


