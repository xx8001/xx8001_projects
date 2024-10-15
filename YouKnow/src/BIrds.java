import java.math.BigInteger;

public class BIrds {
    public static int ff_01(int n) {
        if ( n <= 1) {
            return n;
        }
        else {
            return ff_01(n - 1) + ff_01(n - 2);
        }
    }
    public static int[] f_01() {
        int n = 1;

        while (true) {
            int f = ff_01(n);
            if (f < 0) {
                System.out.println("max fib is " + ff_01(n - 1) + ", which at " + (n - 1));
                return new int[]{n - 1, ff_01(n - 1)};
            }
            n++;
        }
    }

    public static void shhh() {
        int n = 1;
        long timelimit = 30000;
        long starttime = System.currentTimeMillis();

        while (true) {
//            long timwniw = (System.currentTimeMillis() - starttime) / 1000;
//            if (timwniw > 0) {
//                System.out.println(timwniw);
//            }

            long t1 = System.nanoTime();
            long f = noo.f_01(n);
            long t2 = System.nanoTime();
            long duration = t2 - t1;

            System.out.println("Fibonacci(" + n + ") = " + f + ", calculate time: " + duration/ 1_000_000_000.0 + " s");

            if (System.currentTimeMillis() - starttime > timelimit) {
                System.out.println("max fib in 30s  : " + f);
                break;
            }
            n++;
        }
    }

    public static void shhh_1() {
        int n = 1;
        long timelimit = 30000;
        long starttime = System.currentTimeMillis();

        while (true) {
            if (System.currentTimeMillis() - starttime > timelimit) {
                System.out.println("在30秒内计算到的最大斐波那契数是: Fibonacci(" + (n - 1) + ")");
                break;
            }

            long t1 = System.nanoTime();
            long f = noo.f_01(n);//46
//            BigInteger f = f_04(n);
            long t2 = System.nanoTime();
            long duration = t2 - t1;

            System.out.println("Fibonacci(" + n + ") = " + f + ", 计算时间: " + duration / 1_000_000_000.0 + " 秒");

            n++;
        }
    }

    public static BigInteger f_04(int n) {
        if (n <= 1) {
            return BigInteger.valueOf(n);
        }
        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ONE;
        BigInteger result = BigInteger.ZERO;

        for (int i = 2; i <= n; i++) {
            result = a.add(b);
            a = b;
            b = result;
        }
        return result;
    }


    public static void main(String[] args) {
 //       shhh();//46
//        shhh_1();//46
       findMinErrorN();//71
//        System.out.println(ff_04(10));

    }



    public static double phi = (1 + Math.sqrt(5)) / 2;

    public static long ff_04(int n) {
        return Math.round(Math.pow(phi, n) / Math.sqrt(5));
    }

    public static void findMinErrorN() {
        int n = 1;
        while (true) {
            long formulaFibonacci = ff_04(n);//quick ssss
            long iterativeFibonacci = noo.f_04(n);
            if (Math.abs(formulaFibonacci - iterativeFibonacci) > 0) {
                System.out.println("出现误差时的最小 n 值为：" + n);
                break;
            }
            n++;
        }
    }




}
