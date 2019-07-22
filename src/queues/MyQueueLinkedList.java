package queues;

import linkedlist.GenericLinkedList;
import linkedlist.GenericListNode;
import linkedlist.MyLinkedList;

import java.util.LinkedList;

public class MyQueueLinkedList extends GenericLinkedList {

    public static GenericLinkedList linkedList;
    public static int FRONT;
    public static int REAR;
    public static int size;

    MyQueueLinkedList() {
        linkedList = new GenericLinkedList();
        FRONT = -1;
        REAR = -1;
        size = 0;
    }

    static int getSize() {
        return size;
    }

    static boolean isEmpty() {
        if (size == 0) return true;
        return false;
    }

    static void enQueue(Object val) {
        if (getSize() == 0) {
            FRONT = 0;
            REAR = 0;
        } else {
            REAR = (REAR + 1);
        }
        linkedList.addAtTail(val);
        size++;

    }

    static Object deQueue() {
        if (!isEmpty()) {
            Object val = linkedList.getHead().getVal();
            if (getSize() == 1) {
                FRONT = -1;
                REAR = -1;
                linkedList.head = null;
            } else {
                linkedList.deleteAtIndex(FRONT);
                FRONT = (FRONT+1);

            }
            size--;
            return val;
        }
        return null;
    }

    static Object getPeek() {
        if (!isEmpty()) return linkedList.head.getVal();
        return  null;
    }

    static void display () {
        if (!isEmpty()) {
            GenericListNode temp = linkedList.getHead();
            while (temp!=null) {
                System.out.println(temp.getVal());
                temp = temp.getNext();

            }
        }
    }


    public  static void main(String[] arg) {
        MyQueueLinkedList myQueue = new MyQueueLinkedList();
        for (int i = 0; i < 5; i++) {
            myQueue.enQueue(i);
        }

//        System.out.println(isFull());
//        System.out.println(isEmpty());
//        System.out.println(getSize());
        System.out.println("peek:" +getPeek());
        myQueue.display();
        System.out.println(myQueue.deQueue());
        System.out.println("peek:" +getPeek());
        System.out.println("size " +getSize());
        for (int i = 0;i<3;i++) {
            myQueue.deQueue();
        }
        System.out.println("peek:" +getPeek());
        System.out.println("size " +getSize());
        myQueue.deQueue();
        System.out.println("peek:" +getPeek());
        System.out.println("size " +getSize());
    }

}
