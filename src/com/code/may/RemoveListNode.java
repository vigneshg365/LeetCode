package com.code.may;

public class RemoveListNode {

    public static void main(String[] args){
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(13);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(8);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode node = removeNodes(node1);
        while(node!=null){
            System.out.println(node.val);
            node = node.next;
        }
        //System.out.println(removeNodes(node1));
    }

    public static ListNode removeNodes(ListNode head) {
        if (head == null)
            return null;
        head.next = removeNodes(head.next);
        return head.next != null && head.val < head.next.val ? head.next : head;
    }
}


class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val,ListNode next){
        this.val = val;
        this.next = next;
    }
    public ListNode(int val){
        this.val = val;
    }
}
