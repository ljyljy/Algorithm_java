package RemoveNthNodeFromEndofList;

class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
        this.next = null;
    }
}
public class RemoveNthNodeFromEndofList {
    /*
    * @param head: The first node of linked list.
    * @param n: An integer
    * @return: The head of linked list.
    */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // write your code here
        if(n < 0){
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode preDelete = dummy;//定义被删除节点的前驱
        for(int i = 0; i < n; i++){
            //先空转正数n个结点，之后让preDelete和head一起后移，二者始终保持n个距离。当head下一步 走到头(即head走到最后一个节点 )，preDelete刚好是被删结点的前驱
            if(head == null){
                return null;
            }
            head = head.next;
        }
        while(head != null){
            head = head.next;
            preDelete = preDelete.next;
        }
        preDelete.next = preDelete.next.next;
        return dummy.next;
    }
}
