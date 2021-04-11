package offer;

/**
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 *
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 */
public class Offer22 {

    //先遍历统计链表长度，记为 n ；
    //设置一个指针走 (n-k)步，即可找到链表倒数第 k 个节点
    public ListNode getKthFromEnd1(ListNode head, int k) {
        ListNode res = head;

        int len = 1;
        ListNode temp = head;
        while (temp.next != null){
            temp = temp.next;
            len++;
        }

        for(int i = 0; i < len - k; i++){
            res = res.next;

        }
        return res;
    }

    //使用双指针则可以不用统计链表长度。
    public ListNode getKthFromEnd2(ListNode head, int k) {
        ListNode former = head;
        ListNode latter = head;
        int i = 0;
        while (i < k){
            former = former.next;
            i++;
        }
        while (former != null){

            latter = latter.next;
            former = former.next;

        }
        return latter;
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

        Offer22 offer22 = new Offer22();
        System.out.println(offer22.getKthFromEnd1(listNod1, 2).val);
        System.out.println(offer22.getKthFromEnd2(listNod1, 2).val);

    }
}
