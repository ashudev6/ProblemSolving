package linkedlist;

import java.util.HashSet;
import java.util.Set;

public class GetIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode tempA = headA;
        Set<ListNode> set = new HashSet<>();
        while (tempA != null) {
            set.add(tempA);
            tempA = tempA.next;
        }
        ListNode tempB = headB;
        while (tempB != null) {
            if (set.contains(tempB)) {
                return tempB;
            }
            tempB = tempB.next;
        }
        return null;


    }


}
