package linkedlist;

public class RemoveLinkedListElements {

    public  static void main(String[] ar) {
        MyLinkedList list = new MyLinkedList();
        list.addAtIndex(0,1);
        list.addAtIndex(1,6);
        list.addAtIndex(2,3);
        list.addAtIndex(3,6);
        list.printList();
        list.head  = removeElements(list.head,6);
        list.printList();

    }

    public static  ListNode removeElements(ListNode head, int val) {
        if (head == null || (head.next == null && head.val == val) || countVal(head,val)) return null;
        ListNode temp = head;
        while (temp!=null && temp.next!=null) {
            if (temp.next.val == val) {
                temp.next = findNextNode(temp.next,val);
            }
            temp = temp.next;
        }
        if (head.val == val) return head.next;
        return head;

    }

    static  ListNode  findNextNode(ListNode temp,int val) {
        while(temp!=null) {
            if (temp.val!= val) return temp;
            else {
                temp = temp.next;
            }
        }
        return temp;
    }

    static boolean countVal(ListNode head,int val) {
        int countVal = 0;
        int count = 0;
        ListNode temp = head;
        while(temp!=null) {
            if (temp.val == val) countVal++;
            count++;
            temp = temp.next;
        }
        if (countVal == count) return true;
        return false;
    }
}
