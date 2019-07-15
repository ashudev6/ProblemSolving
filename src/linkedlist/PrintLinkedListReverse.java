package linkedlist;

public class PrintLinkedListReverse {
    public static void main(String[] ar) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtIndex(0,1);
        myLinkedList.addAtIndex(1,2);
        myLinkedList.addAtIndex(2,3);
        myLinkedList.printList();
        ListNode temp1 = myLinkedList.getHead();
        ListNode temp2 = myLinkedList.getHead();
        if (temp1 == temp2) System.out.println("yes");
        printReverse(myLinkedList.getHead());
    }

    static void printReverse(ListNode head) {
        if (head!=null) {
            printReverse(head.next);
            System.out.println(head.val);
        }
    }
}
