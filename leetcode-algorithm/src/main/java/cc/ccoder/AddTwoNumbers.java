package cc.ccoder;


/**
 * @author cc.ccoder
 * @since 2019/4/28 20:25
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode a = new ListNode(3);
        ListNode b = new ListNode(4);
        ListNode c = new ListNode(5);
        a.next = b;
        b.next = c;
        ListNode firstNode = a;

        ListNode x = new ListNode(5);
        ListNode y = new ListNode(6);
        ListNode z = new ListNode(2);
        x.next = y;
        y.next = z;
        ListNode secondNode = x;

        ListNode result = new AddTwoNumbers().addTwoNumbers1(firstNode,secondNode);
        System.out.println(result);


    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            if (l1.val > 10) {
                l2 = new ListNode(0);
                l2.next = null;
            } else {
                return l1;
            }
        }
        int temp = l1.val + l2.val;
        if (temp >= 10) {
            if (l1.next == null) {
                l1.next = new ListNode(1);
            } else {
                l1.next.val++;
            }
        }
        l1.next = addTwoNumbers(l1.next, l2.next);
        return l1;
    }

    public ListNode addTwoNumbers1(ListNode first, ListNode second) {
        if (first == null) {
            return second;
        }
        if (second == null) {
            return first;
        }
        // sum : first 和 second 对应节点的和 取值为[0-9]
        int sum;
        // carry : first 和 second 对应节点求和和对应的进位 取值为[0,1]
        int carry = 0;

        ListNode head = new ListNode(0);
        ListNode curr = head;
        while (first != null || second != null || carry != 0) {
            int numFirst = 0;
            int numSecond = 0;
            if (first != null) {
                numFirst = first.val;
                first = first.next;
            }
            if (second != null) {
                numSecond = second.val;
                second = second.next;
            }
            sum = (carry + numFirst + numSecond) % 10;

            curr.next = new ListNode(sum);
            curr = curr.next;

            carry = (carry + numFirst + numSecond) / 10;
        }
        return head.next;
    }


}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        this.val = x;
    }
}