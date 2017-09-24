package RotateListNode;


//翻转链表中第m个节点到第n个节点的部分
//         注意事项
//        m，n满足1 ≤ m ≤ n ≤ 链表长度
//        样例
//        给出链表1->2->3->4->5->null， m = 2 和n = 4，返回1->4->3->2->5->null
//        挑战 
//        在原地一次翻转完成


//  Definition for ListNode
class ListNode {
    int val;
    ListNode next;

    ListNode(int val){
        this.val = val;
    }
}


public class RotateListNode {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m >= n || head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;

        for (int i = 1; i < m; i++) { //空转from-1次，找到起始结点（效果：指针后移到pPre）
            if (head == null) {
                return null;
            }
            head = head.next;
        }

        ListNode premNode = head; //pPre是from的前驱结点
        ListNode mNode = head.next;
        ListNode nNode = mNode;//翻转链表的区域在[m,n]之间。最后pre-m与n连，m与post-m连。
        ListNode postnNode = nNode.next;
        for (int i = m; i < n; i++) {
            if (postnNode == null) {
                return null;
            }
            ListNode temp = postnNode.next;
            postnNode.next = nNode; //向前翻转, 将postnNode插入到nNode之前
            nNode = postnNode;
            postnNode = temp;//后移指针

        }
        mNode.next = postnNode;//(翻转部分)尾部相接: 最后一次翻转结束后，postnNode在末端结点的后面（最后结点的下一个pNext），mNode为翻转的链表的最后一个结点。二者需要相连。
        premNode.next = nNode;//(翻转部分)头部相接：premNode在头部（翻转前from的前驱结点，即反转部分的前一个个结点），nNode一直作为翻转部分的头结点。二者需要相连。

        return dummy.next;
    }

}
