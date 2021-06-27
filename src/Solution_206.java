/**
 * 反转链表
 */
public class Solution_206 {
    public ListNode reverseListA(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
//    递归实现
    public ListNode reverseListB(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode rev = reverseListB(head.next);
        head.next.next = head;
        head.next = null;
        return rev;
    }
}
