import model.ListNode2;

/**
 * @Author ：zhuyuqing.
 * @Date ：Created in 5:20 下午 2021/2/19
 * @Description：环形列表2，找到入环的第一个节点
 * @Modified By：
 * @Version: $
 */
public class DetectCycle2 {
    public ListNode2 detectCycle(ListNode2 head) {
        if (head == null || head.next == null){
            return null;
        }
        ListNode2 f = head.next.next;
        ListNode2 s = head.next;
        while (f != s){
            if (f == null || f.next == null){
                return null;
            }
            f = f.next.next;
            s = s.next;
        }
        ListNode2 cur = head;
        while (cur != s){
            cur = cur.next;
            s = s.next;
        }
        return cur;


    }
}
