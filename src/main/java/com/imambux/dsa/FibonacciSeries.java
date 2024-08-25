package com.imambux.dsa;

public class FibonacciSeries {

    static int x = 0;
    static int y = 1;

    // taking some random array length with default value of -1
    static int[] arrForMemoization = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };

    public static void iFibonacciSeriesUptoNTerms(int n) {
        int x = 0;
        int y = 1;

        if (n >= 1) {
            System.out.print(x + " ");
        }
        if (n >= 2) {
            System.out.print(y + " ");
        }

        int z;
        for (int i = 3; i <= n; i++) {
            z = x + y;
            System.out.print(z + " ");
            x = y;
            y = z;
        }
    }

    public static void rFibonacciSeriesUptoNTerms(int n) {
        if (n == 0) {
            return;
        }
        rFibonacciSeriesUptoNTerms(n - 1);

        if (n == 1) {
            System.out.print(x + " ");
        } else if (n == 2) {
            System.out.print(y + " ");
        } else {
            int r = x + y;
            System.out.print(r + " ");
            x = y;
            y = r;
        }
    }

    /*
    * O(2^n) = if the calls recursive in -1 times every time then it's O(2^n)
    *
    * */
    public static int rFibonacciSeriesUptoNTerms2(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }

        return rFibonacciSeriesUptoNTerms2(n - 2) + rFibonacciSeriesUptoNTerms2(n - 1);
    }

    /*
     * O(n)
     * Uses memoization
     * Memoization = stores the result in an array to use it later to avoid excessive recursive calls
     * */
    public static int rFibonacciSeriesUptoNTerms3(int n) {
        if (n == 1) {
            arrForMemoization[0] = 0;
            return arrForMemoization[0];
        }
        if (n == 2) {
            arrForMemoization[1] = 1;
            return arrForMemoization[1];
        }

        if (arrForMemoization[n - 3] == -1) {
            arrForMemoization[n - 3] = rFibonacciSeriesUptoNTerms3(n - 2);
        }
        if (arrForMemoization[n - 2] == -1) {
            arrForMemoization[n - 2] = rFibonacciSeriesUptoNTerms3(n - 1);
        }
        arrForMemoization[n - 1] = arrForMemoization[n - 3] + arrForMemoization[n - 2];

        return arrForMemoization[n - 1];
    }

    public static void main(String[] args) {
        iFibonacciSeriesUptoNTerms(1);
        System.out.println();
        iFibonacciSeriesUptoNTerms(2);
        System.out.println();
        iFibonacciSeriesUptoNTerms(7);
        System.out.println();
        System.out.println();
        System.out.println();
        rFibonacciSeriesUptoNTerms(1);
        System.out.println();
        rFibonacciSeriesUptoNTerms(2);
        System.out.println();
        rFibonacciSeriesUptoNTerms(7);
        System.out.println();
        System.out.println();
        rFibonacciSeriesUptoNTerms2(1);
        System.out.println();
        rFibonacciSeriesUptoNTerms2(2);
        System.out.println();
        rFibonacciSeriesUptoNTerms2(7);
        System.out.println();
        System.out.println(rFibonacciSeriesUptoNTerms3(1));
        System.out.println(rFibonacciSeriesUptoNTerms3(2));
        System.out.println(rFibonacciSeriesUptoNTerms3(6));
        System.out.println(rFibonacciSeriesUptoNTerms3(7));
    }

}
