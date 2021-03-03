import model.ListNode2;

/**
 * @Author ：zhuyuqing.
 * @Date ：Created in 3:15 下午 2021/2/23
 * @Description：
 * @Modified By：
 * @Version: $
 */
public class HasCycle {
    public boolean hasCycle(ListNode2 head) {
        if (head == null || head.next == null){
            return false;
        }
        ListNode2 slow = head.next;
        ListNode2 fast = head.next.next;
        while (fast != null){
            if (slow == fast){
                return true;
            }
        }
        return false;

    }
}
