package linkedlist;

public class GenericListNode {

    Object val;
    GenericListNode next;
    GenericListNode () {

    }

    GenericListNode(Object val, GenericListNode next) {
        this.val = val;
        this.next = next;
    }

    public Object getVal() {
        return this.val;
    }

    public GenericListNode getNext() {
        return  this.next;
    }

}
