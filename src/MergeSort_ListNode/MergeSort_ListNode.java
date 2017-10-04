package MergeSort_ListNode;

class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
        this.next = null;
    }
}

public class MergeSort_ListNode {



        private static ListNode findMiddle(ListNode head){
            ListNode slow = head;
            ListNode fast = head.next;
            //fast一开始就需要在slow后面！
            //每次fast走两步，slow走一步。
            //当fast走到头(且fast后继结点为空！！！)时，slow刚好走到中点。直接返回slow即可
            while (fast!=null && fast.next!=null){
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }

        private static ListNode merge(ListNode head1, ListNode head2){
            ListNode dummy = new ListNode(0);
            ListNode tail = dummy;
            while (head1!=null && head2!=null){
                if(head1.val < head2.val){
                    tail.next = head1;
                    head1 = head1.next;
                }else{
                    tail.next = head2;
                    head2 = head2.next;
                }
                tail = tail.next;
            }
            if(head1!=null) tail.next = head1;
            else tail.next = head2;

            return dummy.next;
        }

        //归并排序：①链表划分 ②递归。
//	即：需要先找中点。将链表切成两部分。然后继续递归找中点。
//注意每次递归的时候 每次参数是否变化：下面的代码挺危险的，因为两次递归sortList()有可能没砍掉head中的某结点，使得出现递归死循环。为了防止出现StackOverFow，sortList()的传入对象选择中点，这样每次递归都至少会砍掉一个节点。
//Trick：先排右边（mid.next），之后再将中间隔断。
        public static ListNode sortList(ListNode head){
            if(head == null || head.next == null){
                System.out.println();
                return head;//归并排序的终止条件
            }
            ListNode mid = findMiddle(head);
            ListNode right = sortList(mid.next);
            mid.next = null;
            ListNode left = sortList(head);//mid结点之前的 、head的前半段部分

            return merge(left,right);
        }

        private static void printNode(ListNode head){
            if(head == null) return;
            ListNode pCur = head.next;
            while (pCur != null){
                System.out.print(pCur.val + " ");
                pCur = pCur.next;
            }
            System.out.println();
        }

        public static void main(String[] args){
            ListNode head = new ListNode(0);
            head.next = null;
            for(int i=0;i<10;i++){
                ListNode pCur = new ListNode((int)(Math.random()*10));
                pCur.next = head.next;
                head.next = pCur;
            }
            printNode(head);
            ListNode mergedList = sortList(head);
            printNode(mergedList);
        }

}
