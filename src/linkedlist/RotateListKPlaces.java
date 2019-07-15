package linkedlist;

public class RotateListKPlaces {

    public static void main(String[] ar) {
        MyLinkedList list = new MyLinkedList();
        list.addAtIndex(0,1);
        list.addAtIndex(1,2);
        list.addAtIndex(2,3);
        list.printList();
        list.head  = rotateRight(list.head,9);
        list.printList();
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        int size = findListSize(head);
        k = k%size;
        for (int i = 0; i < k; i++) {
            ListNode temp = head;
            while(temp.next.next!= null) {
                temp = temp.next;
            }
            temp.next.next = head;
            head = temp.next;
            temp.next = null;

        }
        return  head;


    }

    static int findListSize(ListNode head) {
        int count = 0;
        ListNode temp = head;
        while (temp!=null) {
            temp = temp.next;
            count++;
        }
        return count;
    }
}
