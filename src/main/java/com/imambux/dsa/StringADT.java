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

    public static void countVowelsAndConsonants(char[] characters) {
        int vowelsCount = 0;
        int consonantsCount = 0;

        for (char character : characters) {
            if (character == 'A'
                || character == 'a'
                || character == 'E'
                || character == 'e'
                || character == 'I'
                || character == 'i'
                || character == 'O'
                || character == 'o'
                || character == 'U'
                || character == 'u'
            ) {
                vowelsCount++;
            } else if((character >= 65 && character <= 90)
                || (character >= 97 && character <= 122)
            ) {
                consonantsCount++;
            }
        }

        System.out.printf("Vowels: %d, Consonants: %d", vowelsCount, consonantsCount);
    }

    public static void countWords(String string) {
        int wordCount = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == ' ' && string.charAt(i - 1) != ' ') {
                wordCount++;
            }
        }

        System.out.printf("Totals Words: %d", wordCount + 1);
    }


    public static void main(String[] args) {
//        changeCase("WelcomE!!!aBc".toCharArray());
//        countVowelsAndConsonants(new char[]{'I', 'm', 'a', 'm', '!'});
//        countWords("Hello there, my name    is Imam Bux.");

    }

}
