package linkedlist;

public class MyLinkedList {



    public static ListNode head = null;
    public static int size = 0;


    public  MyLinkedList() {
        head = null;
        size = 0;
    }

    public  static ListNode getHead() {
        return head;
    }


    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public static int get(int index) {
        if (head == null || index<0 ||index > size) return -1;
        else {
            ListNode temp = head;
            while (temp!=null && index >0){
                temp = temp.next;
                index--;
            }
            if (temp!=null) {
                return temp.val;
            } else {
                return -1;
            }
        }
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        //MyLinkedList listNode = new MyLinkedList(val);
        ListNode listNode = new ListNode(val, null);
        if (head == null) {
            head = listNode;
            size++;
        } else {
            listNode.next = head;
            head = listNode;
            size++;
        }


    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        ListNode listNode = new ListNode(val, null);
        if (head == null) {
            head = listNode;
            size++;
        } else {
            ListNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = listNode;
            size++;

        }
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index <= 0) {
            addAtHead(val);

        }
//        else if (index == getSize()) {
//            addAtTail(val);
//        }
        else if (index > 0){
            ListNode listNode = new ListNode(val, null);
            ListNode temp = head;
            while (temp != null && index > 1) {
                temp = temp.next;
                index--;
            }
            if (temp != null) {
                listNode.next = temp.next;
                temp.next = listNode;
                size++;
            }

        }


    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (head == null || index > getSize() || index < 0 ) return;
        if (index == 0 && head!=null) {
            head = head.next;
        } else {
            ListNode temp = head;
            while (temp!=null && index>1) {
                temp = temp.next;
                index--;
            }
            if (temp!=null && temp.next!=null) {
                temp.next = temp.next.next;
            }
            size--;
        }


    }

    static int getSize() {
        return size;
    }

    void printList() {
        ListNode temp = head;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    void printList(ListNode headGiven) {
        ListNode temp = headGiven;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    public static void main(String[] ar) {
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(10);
        list.addAtHead(20);
        list.addAtTail(30);
        //list.addAtIndex(-1,0);
        System.out.println(list.get(0));
        //list.addAtIndex(4, 40);
        list.printList();
//        list.deleteAtIndex(0);
//        System.out.println("after del");
//        list.printList();
//        System.out.println(get(3));

    }
}
