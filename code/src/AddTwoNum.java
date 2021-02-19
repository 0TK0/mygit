import model.ListNode;

/**
 * @Author ：zhuyuqing.
 * @Date ：Created in 3:55 下午 2021/2/19
 * @Description：
 * @Modified By：
 * @Version: $
 */
public class AddTwoNum {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        l1 = revertList(l1);
        l2 = revertList(l2);


        int curVal = (l1.val + l2.val)%10;
        int jump = (l1.val + l2.val)/10;
        ListNode addList = new ListNode(curVal);
        ListNode cur = addList;
        l1 = l1.next;
        l2 = l2.next;
        while(l1 != null || l2 != null){
            if (l1 == null){
                curVal = (l2.val + jump)%10;
                jump = (l2.val + jump)/10;
                ListNode node = new ListNode(curVal);
                cur.next = node;
                cur = node;
                l2 = l2.next;
                continue;
            }
            if (l2 == null){
                curVal = (l1.val + jump)%10;
                jump = (l1.val + jump)/10;
                ListNode node = new ListNode(curVal);
                cur.next = node;
                cur = node;
                l1 = l1.next;
                continue;
            }
            curVal = (l1.val + l2.val + jump)%10;
            jump = (l1.val + l2.val + jump)/10;
            ListNode node = new ListNode(curVal);
            cur.next = node;
            cur = node;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (jump > 0){
            cur.next = new ListNode(jump);
        }
        return revertList(addList);
    }

    private static ListNode revertList(ListNode head){
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(7);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(2);

        n3.next = n4;
        n2.next = n3;
        n1.next = n2;

        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(3);
        n6.next = n7;
        n5.next = n6;

        ListNode node = addTwoNumbers(n1, n5);
        System.out.println(node);

        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(5);
        ListNode node1 = addTwoNumbers(l1, l2);
        System.out.println(node1);
    }


}
