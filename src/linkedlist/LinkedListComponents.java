package linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LinkedListComponents {

    public  static void main(String[] ar) {
        MyLinkedList list = new MyLinkedList();
        list.addAtIndex(0,0);
        list.addAtIndex(1,1);
        list.addAtIndex(2,2);
        list.addAtIndex(3,3);
        list.printList();
        int [] G = {0,1,3};
        System.out.println(countLinkedListComponents(list.head,G));
        //list.printList();

    }

    static int countLinkedListComponents(ListNode head, int[]G) {
        //int count = 0;
        Set<ListNode> set = new HashSet<>();
        Arrays.sort(G);
        if (G.length > 0) {
            ListNode temp = findNum(head, G[0]);
            ListNode temp1 = temp;
            while (temp.next!=null) {
                System.out.println("index of key:" + temp.next.val+"is : "+Arrays.binarySearch(G,temp.next.val));
                if (Arrays.binarySearch(G,temp.next.val)!= -1) {
                    temp1 = temp1.next;
                } else {
                    set.add(temp1);
                }
                temp = temp.next;
            }
            set.add(temp);
        }
        return set.size();
    }

    static ListNode findNum(ListNode head,int val) {
        ListNode temp = head;
        while (temp!=null) {
            if (temp.val == val) return temp;
            temp = temp.next;
        }
        return temp;
    }
}
