package linkedlist;

public class Compare2LinkedList {

    class SinglyLinkedListNode {
          int data;
          SinglyLinkedListNode next;
    }

    static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        if (head1 == null && head2 == null) {
            return true;
        }

        if (head1 != null && head2 != null) {
            return head1.data == head2.data && compareLists(head1.next, head2.next);
        }
        return false;


    }
}
