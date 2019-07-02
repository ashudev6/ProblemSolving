package interviews;

import java.util.ArrayList;
import java.util.List;

public class OddDigitPrime {
    public static void main(String[] ar) {
        System.out.println(findOddDigitPrimeCount(1, 50, 1));
    }

    public static int findOddDigitPrimeCount(int l, int r, int t) {

        int count_t_1 = 0;
        int count_t_2 = 0;
        for (int i = l; i <= r; i++) {
            if (isPrime(i)) {
                List<Integer> primeList = digitArray(i);
                if (!primeList.contains(2)) {
                    int count_5_less = 0;
                    int count_5_more = 0;
                    int count_5 = 0;
                    for (int j = 0; j < primeList.size(); j++) {
                        if (primeList.get(j) < 5) {
                            count_5_less++;
                        } else if (primeList.get(j) == 5) {
                            count_5++;
                        } else if (primeList.get(j)> 5) {
                            count_5_more++;
                        }
                    }
                    if (count_5+count_5_less == primeList.size()) {
                        count_t_1++;
                    }
                    if (count_5 +count_5_more == primeList.size()) {
                        count_t_2++;
                    }
                }
            }
        }
        if (t == 1) {
            return count_t_1;
        } else {
            return count_t_2;
        }




    }

    static boolean isPrime(int n) {
        // Corner case
        if (n <= 1)
            return false;

        // Check from 2 to n-1
        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return false;

        return true;
    }

    static List<Integer> digitArray(int num) {
        List<Integer> digits = new ArrayList<>();
        if (num == 0) {
            digits.add(0);
            return digits;
        }


        //for (; num != 0; num /= 10)
        while (num != 0) {
            digits.add(num % 10);
            num /= 10;
        }


        return digits;
    }
}
