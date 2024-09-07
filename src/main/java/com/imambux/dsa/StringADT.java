package com.imambux.dsa;

public class StringADT {

    public static void changeCase(char[] characters) {
        for (int i = 0; i < characters.length; i++) {
            if (characters[i] >= 65 && characters[i] <= 90) {
                characters[i] += 32;
            } else if(characters[i] >= 97 && characters[i] <= 122) {
                characters[i] -= 32;
            }
        }

        System.out.println(characters);
    }

    public static void main(String[] args) {
        // Change Case
        changeCase("WelcomE!!!aBc".toCharArray());
    }

}
