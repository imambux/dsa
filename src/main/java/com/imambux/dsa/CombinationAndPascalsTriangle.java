package com.imambux.dsa;

/*
 * Combination Formula: ^nC_r = n! / r!(n - r)!
 * Pascals Triangle: ^nC_r = ^{n-1}C_{r-1} + ^{n-1}C_{r} - used for recursion
 * */
public class CombinationAndPascalsTriangle {

    public static int mGetNumberOfCombination(int n, int r) {
        if (r == String.valueOf(n).length()) return 1;

        int factorialOfN = getFactorialOf(n);

        int factorialOfR = getFactorialOf(r);

        int factorialOfNAndR = getFactorialOf((n - r));

        return factorialOfN / (factorialOfR * factorialOfNAndR);
    }

    /*
    * Pascal's Triangle to find the combination of n
    * */
    public static int rGetNumberOfCombination(int n, int r) {
        if (n == r || r == 0) return 1;

        return rGetNumberOfCombination(n - 1, r - 1) + rGetNumberOfCombination(n - 1, r);
    }

    private static int getFactorialOf(int n) {
        int factorialOfN = 1;
        for (int i = 1; i <= n; i++) {
            factorialOfN *= i;
        }
        return factorialOfN;
    }

    public static void main(String[] args) {
        System.out.println(mGetNumberOfCombination(4, 2));
        System.out.println(rGetNumberOfCombination(4, 2));
    }

}
