package linkedlist;

public class MiddleOfList {

    public ListNode middleNode(ListNode head) {
        ListNode temp = head;

        while (temp != null) {
            temp = temp.next;
            if (temp != null) {
                temp = temp.next;
                head = head.next;
            }
        }

        return head;


    }
}
