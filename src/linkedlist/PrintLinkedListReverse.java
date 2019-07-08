package linkedlist;

public class PrintLinkedListReverse {
    public static void main(String[] ar) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtIndex(0,1);
        myLinkedList.addAtIndex(1,2);
        myLinkedList.addAtIndex(2,3);
        myLinkedList.printList();
        printReverse(myLinkedList.getHead());
    }

    static void printReverse(Node head) {
        if (head!=null) {
            printReverse(head.next);
            System.out.println(head.val);
        }
    }
}
