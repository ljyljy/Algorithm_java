package AddTwoNumbers;

public class AddTwoNumbersV2 {
    /**
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2
     */
    public ListNode addLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        int carry = 0;
        for (ListNode i = l1, j = l2; i != null || j != null; ) {
            int sum = carry;
            sum += (i != null) ? i.val : 0;
            sum += (j != null) ? j.val : 0;

            tail.next = new ListNode(sum % 10);
            tail = tail.next;

            carry = sum / 10;
            i = (i == null) ? i : i.next;
            j = (j == null) ? j : j.next;
        }

        if (carry != 0) {
            tail.next = new ListNode(carry);
        }
        return dummy.next;
    }

}
