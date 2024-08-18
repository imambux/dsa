public class PowerOfM {

    public static int rPowOf(int m, int n) {
        if (n == 0) {
            return 1;
        }

        return rPowOf(m, n - 1) * m;
    }

    public static int rPowOf2(int m, int n) {
        if (n == 0) {
            return 1;
        }

        if (n % 2 == 0) {
            return rPowOf2(m * m, n / 2);
        } else {
            return m * rPowOf2(m * m, (n - 1) / 2);
        }
    }

    public static int iPowOf(int m, int n) {
        if (n == 0) {
            return m;
        }

        int total = 1;
        for (int i = 1; i <= n; i++) {
            total *= m;
        }

        return total;
    }

    public static void main(String[] args) {
        System.out.println(rPowOf(2, 9));
        System.out.println(rPowOf2(2, 9));
        System.out.println(iPowOf(2, 9));
    }

}
