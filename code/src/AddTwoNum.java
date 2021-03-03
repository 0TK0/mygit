import model.ListNode2;

/**
 * @Author ：zhuyuqing.
 * @Date ：Created in 3:55 下午 2021/2/19
 * @Description：
 * @Modified By：
 * @Version: $
 */
public class AddTwoNum {
    public static ListNode2 addTwoNumbers(ListNode2 l1, ListNode2 l2) {
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
        ListNode2 addList = new ListNode2(curVal);
        ListNode2 cur = addList;
        l1 = l1.next;
        l2 = l2.next;
        while(l1 != null || l2 != null){
            if (l1 == null){
                curVal = (l2.val + jump)%10;
                jump = (l2.val + jump)/10;
                ListNode2 node = new ListNode2(curVal);
                cur.next = node;
                cur = node;
                l2 = l2.next;
                continue;
            }
            if (l2 == null){
                curVal = (l1.val + jump)%10;
                jump = (l1.val + jump)/10;
                ListNode2 node = new ListNode2(curVal);
                cur.next = node;
                cur = node;
                l1 = l1.next;
                continue;
            }
            curVal = (l1.val + l2.val + jump)%10;
            jump = (l1.val + l2.val + jump)/10;
            ListNode2 node = new ListNode2(curVal);
            cur.next = node;
            cur = node;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (jump > 0){
            cur.next = new ListNode2(jump);
        }
        return revertList(addList);
    }

    private static ListNode2 revertList(ListNode2 head){
        ListNode2 cur = head;
        ListNode2 pre = null;
        while (cur != null){
            ListNode2 next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode2 n1 = new ListNode2(7);
        ListNode2 n2 = new ListNode2(1);
        ListNode2 n3 = new ListNode2(4);
        ListNode2 n4 = new ListNode2(2);

        n3.next = n4;
        n2.next = n3;
        n1.next = n2;

        ListNode2 n5 = new ListNode2(5);
        ListNode2 n6 = new ListNode2(6);
        ListNode2 n7 = new ListNode2(3);
        n6.next = n7;
        n5.next = n6;

        ListNode2 node = addTwoNumbers(n1, n5);
        System.out.println(node);

        ListNode2 l1 = new ListNode2(5);
        ListNode2 l2 = new ListNode2(5);
        ListNode2 node1 = addTwoNumbers(l1, l2);
        System.out.println(node1);
    }


}
