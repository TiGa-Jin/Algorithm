package offer;

public class Offer18 {
    public ListNode deleteNode(ListNode head, int val) {
        if(head.val == val)
            return head.next;
        ListNode tmp = head;
        while (tmp.next != null){
            if(tmp.next.val == val)
                tmp.next = tmp.next.next;
            if(tmp.next == null)
                break;
            tmp = tmp.next;
        }
        return head;
    }

}
