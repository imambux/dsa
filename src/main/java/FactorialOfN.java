
/*
* 0! = 1
* */
public class FactorialOfN {

    /*
    * Recursion
    * */
    public static int rFactorialOf(int n) {
        if (n == 0) {
            return 1;
        }

        return rFactorialOf(n - 1) * n;
    }

    /*
     * Loop
     * */
    public static int iFactorialOf(int n) {
        int total = 1;

        for (int i = n; i > 0; i--) {
            total = i * total;
        }

        return total;


    }

    public static void main(String[] args) {
        System.out.println(rFactorialOf(5));
        System.out.println(iFactorialOf(5));
    }

}
