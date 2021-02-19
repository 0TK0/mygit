import model.ListNode;

/**
 * @Author ：zhuyuqing.
 * @Date ：Created in 2:54 下午 2021/2/19 @Description：
 * @Modified By：
 * @Version: $
 */
public class MergeTwoList {
    /**
     * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {} ListNode(int
     * val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val; this.next = next; } }
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head;
        if (l1.val < l2.val) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }
        ListNode cur = head;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                cur.next = l2;
                l2 = l2.next;
                cur = cur.next;
                continue;
            }
            if (l2 == null) {
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
                continue;
            }
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
                cur = cur.next;
            }
        }
        return head;
    }
}
