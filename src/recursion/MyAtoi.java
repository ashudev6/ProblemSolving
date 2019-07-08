package recursion;

public class MyAtoi {

    public static void main(String[] ar) {
        String s = "42";
        System.out.println(myAtoi(s));
        s = "   -42";
        System.out.println(myAtoi(s));
        s = "4193 with words";
        System.out.println(myAtoi(s));
        s = "words and 987";
        System.out.println(myAtoi(s));
        s = "-91283472332";
        System.out.println(myAtoi(s));
        s= "123456789012345";
        System.out.println(myAtoi(s));
    }

    static int myAtoi(String str) {
        return atoiRecursion(str);
    }

    static int atoiRecursion(String str) {
        //System.out.println("len of str: " +str.length());
        if (str.length() == 0) return  0;

        int sign = 1;

        str  =str.trim();
        if (str.equals("")) return  0;

        long sum = 0;
        int start = 0;
        if(str.charAt(0) == '+') {
            sign = 1;
            start++;
        }
        if (str.charAt(0) == '-') {
            sign = -1;
            start++;
        }
        //System.out.println("start:" + start);
        sum = getNum(str,start,(int) sum,sign);
        return (int) sum;

    }

    static long getNum(String str,int start,long sum, int sign) {
        //System.out.println("sum:" + sum);
        if (sign == 1 && sum > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (sign == -1 && sum < Integer.MIN_VALUE) {
            return  Integer.MIN_VALUE;
        }

        if(start > str.length()-1 || !Character.isDigit(str.charAt(start))) {
            return sum*sign;
        }

        sum = sum*10 + str.charAt(start) -'0';
        return getNum(str,start+1,sum,sign);
    }
}
