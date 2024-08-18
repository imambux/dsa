/*
* sum(n-1)+n
* fact(n-1)*n
* pow(x,n-1)*x
*
* In Taylor Series: 1 + x/1 + x^2/2! + x^3/3! + x^4/4! + ... + n terms
*
* */
public class TaylorSeries {

    static double power = 1;
    static double factorial = 1;

    static double sum = 1;

    public static double rTaylorSeries(int x, int n) {
        if (n == 0) return 1;

        double result = rTaylorSeries(x, n - 1);
        power *= x;
        factorial *= n;

        return result + (power/factorial);
    }

    /*
    * This is the optimized version of Taylor Series
    * */
    public static double rTaylorSeries2(int x, int n) {
        if (n == 0) return sum;

        sum = 1 + (double) x / n * sum;

        return rTaylorSeries2(x, n - 1);
    }

    /*
    * This is the optimized version of Taylor Series
    * T = O(n)
    * */
    public static double iTaylorSeries2(int x, int n) {
        double result = 1;

        for (; n > 0; n--) {
            result = 1 + (double) x / n * result;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("Taylor Series: " + rTaylorSeries(3, 10));
        System.out.println("Taylor Series: " + rTaylorSeries2(3, 10));
        System.out.println("Taylor Series: " + iTaylorSeries2(3, 10));
    }

}
