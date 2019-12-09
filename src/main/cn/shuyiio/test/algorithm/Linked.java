package cn.shuyiio.test.algorithm;

public class Linked {


    /**
     * 反转链表
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head){
        if (head == null){
            return null;
        }
        if (head.next == null){
            return head;
        }


        ListNode current = head;
        ListNode prev = null;

        while (current != null){
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public String stradd(String str){
        return "123" + str;
    }


    class ListNode {
        ListNode next;
    }

}
