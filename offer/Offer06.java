/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 */

package offer;

import java.util.Stack;

public class Offer06 {


    public int[] reversePrint(ListNode head) {

        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        int size = stack.size();
        int[] arrys = new int[size];
        for(int i = 0; i <size; i++){
            arrys[i] = stack.pop().val;
        }
        return arrys;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);

        head.next = node1;
        node1.next = node2;

        Offer06 offer06 = new Offer06();

        int[] arrys = offer06.reversePrint(head);

        for(int i=0; i < arrys.length; i++){
            System.out.println(arrys[i]);
        }


    }


}
