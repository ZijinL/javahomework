public class isPrime {
    public static void main(String[] args) {
        for (int i = 1; i < 100; i++) {
            if (isprime_n2(i)) {
                System.out.println(i);
            }
        }
    }

    public static boolean isprime_n2(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static boolean isprime_nsqrt(int m) {
        for (int i = 2; i <= Math.sqrt(m); i++) {
            if (m % i == 0)
                return false;
        }
        return true;
    }



}
