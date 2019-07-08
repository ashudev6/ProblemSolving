package recursion;

public class ChocolateFeast {

    public  static  void main(String[] ar) {
        int n = 10, c = 2, m = 5;
        System.out.println(chocolateFeast(n, c, m));
        n = 12;
        c = 4;
        m = 4;
        System.out.println(chocolateFeast(n, c, m));
        n = 6;
        c = 2;
        m = 2;
        System.out.println(chocolateFeast(n, c, m));

    }

    static int chocolateFeast(int n, int c, int m) {
        return n/c + countWrapper(n/c,m);



    }

    static int countWrapper(int w,int m) {
        if (w< m) return 0;

        return w/m + countWrapper((w/m + w%m),m);

    }
}
