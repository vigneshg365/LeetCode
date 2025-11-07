package com.code.may;

public class ListNodeMultiple {
        public static void main(String[] args){
            ListNode node1 = new ListNode(1);
            ListNode node2 = new ListNode(8);
            ListNode node3 = new ListNode(9);
            node1.next = node2;
            node2.next = node3;
            ListNode temp = doubleIt(node1);
            while(temp!=null){
                System.out.print(temp.val+" ");
                temp = temp.next;
            }
        }

    public static ListNode doubleIt(ListNode head) {
        String mul = "";
        ListNode temp = head;
        while(temp!=null){
            mul = mul+temp.val;
            temp = temp.next;
        }
        int value = Integer.parseInt(mul)*2;
        mul = String.valueOf(value);
        int index=0;
        return multiple1(head,mul,index);
    }

    public static ListNode multiple(ListNode head, String mul){
        int index = 0;
        ListNode temp = head;
        while(temp!=null){

            head.val = (Integer.parseInt(String.valueOf(mul.charAt(index))));
            index++;
            temp = temp.next;
        }

        return head;

    }
    public static ListNode multiple1(ListNode head, String mul, int index){
            if(head == null)
                return null;
            head.val = Integer.parseInt(String.valueOf(mul.charAt(index)));
            head.next = multiple1(head.next,mul,index+1);
            if(head.next!=null)
                return head.next;
            else
                return head;
    }
}
