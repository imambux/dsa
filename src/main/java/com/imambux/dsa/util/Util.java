package com.imambux.dsa.util;

import java.util.Scanner;

public class Util {
    private static final Scanner input = new Scanner(System.in);

    public static int getIntegerUserInput(String msg) {
        if (!msg.isEmpty()) {
            System.out.printf("%s: ", msg);
        }

        return input.nextInt();
    }

    public static int getIntegerUserInput() {
        return getIntegerUserInput("");
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
