package linkedlist;

public class DoublyLinkedListNode {

    int data;
    DoublyLinkedListNode next;
    DoublyLinkedListNode prev;

    DoublyLinkedListNode(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
