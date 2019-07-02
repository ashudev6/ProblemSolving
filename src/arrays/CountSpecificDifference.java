package arrays;

import java.util.Scanner;

public class CountSpecificDifference {

    public static void main(String[] ar) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
             int N = sc.nextInt();
             int D = sc.nextInt();
             System.out.println(findCountSpecificDifference(N,D));
        }
    }

    static int findCountSpecificDifference(int N,int D) {
        int count = 0;
        if (D == 0) {
            count = N;
        } else if (D>0 & D<N) {
            int div = D/9;
            int mod = D%9;
            if (div>0) {
                int end = 0;
                if (mod > 0) {
                    div = div+1;
                }
                end = 10*div;
                if (10*div <=N && end -getSum(end) >=D) {
                    count = N-end +1;
                }
                for (int j=div-1;j>0;j--) {
                    if (10*j - getSum(10*j)>=D) {
                        count = count+10;
                    } else{
                        break;
                    }
                }
            } else if (div == 0) {
                count = N-9;
            }
        }
        return count;
    }

    static int getSum(int n)
    {
        int sum = 0;

        while (n != 0)
        {
            sum = sum + n % 10;
            n = n/10;
        }
        return sum;
    }

}
