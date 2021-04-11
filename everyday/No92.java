package everyday;

/**
 * 92. 反转链表 II
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 * 算法步骤：
 *
 * 第 1 步：先将待反转的区域反转；
 * 第 2 步：把 pre 的 next 指针指向反转以后的链表头节点，把反转以后的链表的尾节点的 next 指针指向 succ。
 *
 */
public class No92 {
    public class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){
            this.val = val;
        }
        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 因为头节点有可能发生变化，使用虚拟头节点可以避免复杂的分类讨论
        ListNode copyHead = new ListNode(-1);
        copyHead.next = head;

        ListNode pre = copyHead;

        // 第 1 步：从虚拟头节点走 left - 1 步，来到 left 节点的前一个节点
        // 建议写在 for 循环里，语义清晰
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        // 第 2 步：从 pre 再走 right - left + 1 步，来到 right 节点
        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }
        // 第 3 步：切断出一个子链表（截取链表）
        ListNode leftNode = pre.next;
        ListNode succNode = rightNode.next;

        // 注意：切断链接
        pre.next = null;
        rightNode.next = null;


        // 第 4 步：同第 206 题，反转链表的子区间
        ListNode curNode = leftNode;
        ListNode preNode = null;
        while (curNode != null){
            ListNode next = curNode.next;
            preNode = curNode.next;
            preNode = curNode;
            curNode = next;
        }

        // 第 5 步：接回到原来的链表中
        pre.next = rightNode;
        leftNode.next = succNode;
        return copyHead.next;

    }




}
