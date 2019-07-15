package stack;

public class MyStack {

    public static int CAPACITY = 0;
    public static int TOP = -1;
    public static Object[] arr;

    MyStack(int capacity) {
        CAPACITY = capacity;
        arr = new Object[CAPACITY];
        TOP = -1;
    }

    static boolean isEmpty() {
        if (TOP == -1) return true;
        return false;
    }

    static void push(Object val) {
        if (!isFull()) {
            TOP = TOP+1;
            arr[TOP] = val;
        }
    }

    static boolean isFull() {
        if (TOP+1 == CAPACITY) return  true;
        return false;
    }

    static Object pop() throws  NullPointerException{
        if(!isEmpty()) {
            Object val = arr[TOP];
            TOP--;
            return val;
        }
        return null;
    }

    static int getSize() {
        return  TOP+1;
    }

    static Object peek() throws NullPointerException {
        if(!isEmpty()) {
            return arr[TOP];
        }
        return null;
    }
    static void display() {
        if (!isEmpty()) {
            for (int i = TOP; i >=0 ; i--) {
                 System.out.println(arr[i]);
            }
        }

    }


    public static void main(String[] arg) {
        MyStack myStack = new MyStack(10);
        for (int i = 0; i < 10; i++) {
            myStack.push(i);
        }
        for (int i = 0; i < 2; i++) {
            myStack.pop();
        }
        myStack.display();
        System.out.println(getSize());
        System.out.println(peek());
    }



}
