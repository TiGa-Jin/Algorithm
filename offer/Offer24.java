package offer;

/**
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 */
public class Offer24 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode listNod1 = new ListNode(1);
        ListNode listNod2 = new ListNode(2);
        ListNode listNod3 = new ListNode(3);
        ListNode listNod4 = new ListNode(4);
        ListNode listNod5 = new ListNode(5);
        ListNode listNod6 = new ListNode(6);

        listNod1.next = listNod2;
        listNod2.next = listNod3;
        listNod3.next = listNod4;
        listNod4.next = listNod5;
        listNod5.next = listNod6;

        Offer24 offer24 = new Offer24();
        ListNode head = offer24.reverseList(listNod1);
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
