package linkedlist;

public class RemoveNthNodeFromLast {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return head;
        int size = findListSize(head);
        int index = size - n;
        head = deleteAtIndex(head, index, size);
        return head;


    }

    static int findListSize(ListNode head) {
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }

    static ListNode deleteAtIndex(ListNode head, int index, int size) {
        if (head == null || index > size || index < 0) return head;
        if (index == 0 && head != null) {
            head = head.next;
            return head;
        } else {
            ListNode temp = head;
            while (temp != null && index > 1) {
                temp = temp.next;
                index--;
            }
            if (temp != null && temp.next != null) {
                temp.next = temp.next.next;
            }


        }
        return head;


    }
}
