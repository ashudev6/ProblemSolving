package recursion;

public class SumOfDigits {

    public static void main(String[] ar) {
        int num = 1234599;
        System.out.println("sum of digits of " + num +" is: " + findSum(num));
    }

    static int findSum(int num) {
        if (num/10 == 0) return  num%10;
        return num%10+findSum(num/10);
    }
 }
