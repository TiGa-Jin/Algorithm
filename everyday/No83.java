package everyday;

import java.util.LinkedList;
import java.util.List;

public class No83 {


     //Definition for singly-linked list.
     public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    public ListNode deleteDuplicates(ListNode head) {
         if (head == null || head.next == null){
             return head;
         }
         ListNode backHead = head;
         ListNode cur = head;

         while (cur.next != null){
             if (cur.val == cur.next.val){
                 cur.next = cur.next.next;
             }else {
                 cur = cur.next;
             }
         }
         return backHead;
    }
}
