package linkedlist;


public class ReverseList {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode rest = reverseList(head.next);

        head.next.next = head;
        head.next = null;

        return rest;

    }

    public static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        DoublyLinkedListNode rest = reverse(head.next);

        head.next.next = head;
        head.prev= head.next;
        head.next = null;

        return rest;



    }
}
