package linkedlist;

public class InsertNumSortedDoublyLinkedList {

    DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
        DoublyLinkedListNode node = new DoublyLinkedListNode(data);
        if (head == null) {
            head = node;
            return head;
        }
        if (head.data >= data) {
            node.next = head;
            head =node;
            return head;
        }
        DoublyLinkedListNode temp = head;
        boolean added = false;
        while(temp.next!=null) {
            if (temp.data>= data) {
                temp.prev.next = node;
                node.next = temp;
                break;
            }
            temp = temp.next;
        }
        if (temp.data< data) {
            temp.next = node;
            node.prev = temp;
        } else {
            temp.prev.next = node;
            node.next = temp;
        }
        return head;

    }
}
