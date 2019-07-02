package recursion;

public class DecByFive {

    public static void main(String[] ar) {
        doDecByFive1(10);
    }

    static void doDecByFive(int n) {
        if (n <= 0) {
            System.out.println(n);
            return;
        }
        System.out.println(n);
        doDecByFive(n - 5);
        System.out.println(n);
    }

    static void doDecByFive1(int n) {

        System.out.println(n);
        if (n <= 0) return;

        doDecByFive(n - 5);
        System.out.println(n);
    }
}
