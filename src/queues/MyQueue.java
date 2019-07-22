package queues;


public class MyQueue {

    public static int CAPACITY;
    public static int FRONT ;
    public static int REAR;
    public static Object[] arr;
    public static int size;

    MyQueue(int capacity) {
        CAPACITY = capacity;
        FRONT = -1;
        REAR = -1;
        arr = new Object[CAPACITY];
        size = 0;
    }

    static int getSize() {
//        if (REAR == -1 &&  FRONT == -1) return 0;
//        return REAR - FRONT + 1;
        return size;
    }

    static boolean isFull() {
        if (getSize() == CAPACITY) return true;
        return false;
    }

    static boolean isEmpty() {
        if (getSize() == 0) return true;
        return false;

    }

    static void enQueue(Object val) {
        if (!isFull()) {
            if (getSize() == 0) {
                FRONT = 0;
                REAR = 0;
                arr[REAR] = val;
            } else {
                REAR = (REAR + 1) % CAPACITY;
                arr[REAR] = val;
            }
            size++;
        }
    }

    static Object deQueue() {
        if (!isEmpty()) {
            Object val = arr[FRONT];
            if (getSize() == 1) {
                FRONT = -1;
                REAR = -1;
            } else {
               FRONT = (FRONT+1)%CAPACITY;
            }
            size--;
            return val;
        }
        return null;
    }

    static Object getPeek () {
        if (!isEmpty()) {
            return arr[FRONT];
        }
        return  null;
    }

    static void display() {
        if (!isEmpty()) {
            for (int i = FRONT; i <=REAR; i++) {
                System.out.println(arr[i]);
            }
        }

    }

    public static void main(String [] ar) {
        MyQueue myQueue = new MyQueue(5);
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
