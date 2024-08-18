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

    public static double taylorSeries(int x, int n) {
        if (n == 0) return 1;

        double result = taylorSeries(x, n - 1);
        power *= x;
        factorial *= n;

        return result + (power/factorial);
    }

    public static void main(String[] args) {
        System.out.println("Taylor Series: " + taylorSeries(3, 10));
    }

}
