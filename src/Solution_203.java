import java.util.List;
/**
 * 链表删除节点
 */
public class Solution_203 {
//    普通实现
    public ListNode removeElementsB(ListNode head, int val) {
//        访问链表时不知道链表长度，必须判断非空。。否则对一个空链表进行  head.val == val 判断会报错。同样的道理，数组的index位置时候也需要判断。
        while (head != null && head.val == val){
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }
        if (head == null){
            return head;
        }
        ListNode prev = head;
        while (prev.next != null){
            if (prev.next.val == val){
                ListNode delNode = prev.next;
                prev.next = prev.next.next;
                delNode.next = null;
            }else {
                prev = prev.next;
            }
        }
        return head;
    }
//    虚拟头节点实现
    public ListNode removeElementsA(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1, head);
        ListNode prev = dummyHead;
        while (prev.next != null){
            if (prev.next.val == val){
                prev.next = prev.next.next;
            }else {
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }
//    递归实现
    public ListNode removeElementsC(ListNode head, int val) {
        if (head == null){
            return head;
        }
        head.next = removeElementsC(head.next,val);
        return head.val == val ? head.next : head;
    }
    public static void main(String[] args) {
        int[] array = {1,2,6,3,4,5,6};
        ListNode list = new ListNode(array);
        System.out.println(list);
        ListNode res = (new Solution_203()).removeElementsC(list, 6);
        System.out.println(res);
    }
}
