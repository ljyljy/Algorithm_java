package AddTwoNumbersII;

//假定用一个链表表示两个数，其中每个节点仅包含一个数字。假设这两个数的数字顺序排列，请设计一种方法将两个数相加，并将其结果表现为链表的形式。
//样例
//        给出 6->1->7 + 2->9->5。即，617 + 295。
//        返回 9->1->2。即，912 。

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class AddTwoNumbersII {
    /**
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2
     */
    public ListNode addLists2(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);

        return reverse(addList1(l1, l2));
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }

    private ListNode addList1(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        int carry = 0;

        while (l1 != null && l2 != null) {
            tail.next = new ListNode((l1.val + l2.val + carry) % 10);
            tail = tail.next;
            carry = (l1.val + l2.val + carry) / 10;

            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            tail.next = new ListNode((l1.val + carry) % 10);
            tail = tail.next;
            carry = (l1.val + carry) / 10;

            l1 = l1.next;
        }
        while (l2 != null) {
            tail.next = new ListNode((l2.val + carry) % 10);
            tail = tail.next;
            carry = (l2.val + carry) / 10;

            l2 = l2.next;
        }

        while (carry != 0) {
            tail.next = new ListNode(carry % 10);
            tail = tail.next;
            carry = carry / 10;
        }

        return dummy.next;
    }
}
