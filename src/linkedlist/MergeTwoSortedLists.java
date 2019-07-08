package linkedlist;

public class MergeTwoSortedLists {

     public  static  void main(String[] ar) {
         MyLinkedList list1 = new MyLinkedList();
//         Node n1 = new Node(1,null);
//         Node n2 = new Node(2,null);
//         Node n4 = new Node(4,null);
         list1.addAtHead(1);
         list1.addAtTail(2);
         list1.addAtTail(4);
         list1.printList();
         MyLinkedList list2 = new MyLinkedList();
         list2.addAtHead(1);
         list2.addAtTail(2);
         list2.addAtTail(3);
         list2.printList();
         Node l3 = new Node();
         l3 = mergeTwoLists(list1.getHead(),list2.getHead());
         //System.out.println(l3.val);
         while (l3!=null) {
             System.out.println(l3.val);
             l3 = l3.next;
         }
         //list3.printList();

     }

     static Node mergeTwoLists(Node l1,Node l2) {
        int n1=0,n2=0;
        if (l1!= null) {
            n1 = findListSize(l1);
        }
        if (l2!=null) {
            n2 = findListSize(l2);
        }
        if (n1 >=n2) {
            Node t1 = l1;
            Node t2 = l2;
            while (t2!= null) {
                if (t1.val > t2.val) {
                    Node add = new Node(t2.val,t1.next);
                    t1.next = add;
                    t2 = t2.next;
                    t1 = t1.next;
                } else {
                    //Node add = new Node(t1.val,t1);
                    t1 = t1.next;

                }
            }
            return l1;
        }
        return l2;
     }

    static int findListSize(Node head) {
        int count = 0;
        Node temp = head;
        while(temp!=null) {
            temp = temp.next;
            count++;
        }
        return count;
    }



}
