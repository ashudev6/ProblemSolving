package recursion;

public class FindFactorial {
    public  static void main(String[] ar) {
        int num = 8;
        System.out.println("factorial of " + num+ " is : " + doFindFactorial(num));
    }

    static int doFindFactorial(int n) {
        if (n<=1) return 1;
        return n*doFindFactorial(n-1);
    }
}
