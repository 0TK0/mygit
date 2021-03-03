import model.ListNode2;

/**
 * @Author ：zhuyuqing.
 * @Date ：Created in 2:54 下午 2021/2/19 @Description：
 * @Modified By：
 * @Version: $
 */
public class MergeTwoList {
    /**
     * Definition for singly-linked list. public class ListNode2 { int val; ListNode2 next; ListNode2() {} ListNode2(int
     * val) { this.val = val; } ListNode2(int val, ListNode2 next) { this.val = val; this.next = next; } }
     */
    public ListNode2 mergeTwoLists(ListNode2 l1, ListNode2 l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode2 head;
        if (l1.val < l2.val) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }
        ListNode2 cur = head;
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
