package com.imambux.dsa;

public class SumOfFirstNNaturalNumbers {

    /*
    * Recursion
    * T = O(n)
    * S = O(n)
    * */
    public static int rSumOfFirstNaturalNumbers(int n) {
        if (n > 0) {
            return rSumOfFirstNaturalNumbers(n - 1) + n;
        }
        return 0;
    }

    /*
     * Math formula
     * T = O(1)
     * */
    public static int mSumOfFirstNaturalNumbers(int n) {
        return n * (n + 1) / 2;
    }

    /*
     * Loop
     * T = O(n)
     * */
    public static int iSumOfFirstNaturalNumbers(int n) {
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            sum += i;
        }

        return sum;
    }

    /*
     * Math formula
     * */
    public static int sumOfFirstNNaturalEvenNumbers2(int n) {
        return n * (n + 1);
    }

    public static void main(String[] args) {
        System.out.println(rSumOfFirstNaturalNumbers(6));
        System.out.println(mSumOfFirstNaturalNumbers(6));
        System.out.println(iSumOfFirstNaturalNumbers(6));

        System.out.println(sumOfFirstNNaturalEvenNumbers2(5));
    }

}
