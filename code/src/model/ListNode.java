package model;

/**
 * @Author ：zhuyuqing.
 * @Date ：Created in 2:56 下午 2021/2/19 @Description：
 * @Modified By：
 * @Version: $
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {}

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}
