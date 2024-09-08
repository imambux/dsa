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

    public static void reverseString(String string) {
        char[] characters = string.toCharArray();

        int i = 0;
        int j = characters.length - 1;

        while (i < j) {
            char temp = characters[i];
            characters[i] = characters[j];
            characters[j] = temp;
            i++;
            j--;
        }

        System.out.println(characters);
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

    public static void findDuplicatesForLowerCaseOnly(String string) {
        int[] lowerCaseCharacters = new int[26];

        for (int i = 0; i < string.length() - 1; i++) {
            lowerCaseCharacters[string.charAt(i) - 97]++;
        }

        for (int i = 0; i < lowerCaseCharacters.length; i++) {
            if (lowerCaseCharacters[i] > 1) {
                System.out.printf("%c:%d%n", i + 97, lowerCaseCharacters[i]);
            }
        }
    }

    public static void findDuplicatesForLowerCaseOnlyUsingBitwiseOperator(String string) {
        // Take 26 bits to accomodate all lower case english characters
        // We can take 32 bits instead = Integer = 32 bits = 4 bytes but we are only interested in the first 26 bits
        int H = 0; // to make all bits 0

        // loop through each character
        for(int i = 0; i < string.length(); i++) {
            // take a variable that has 1 bit ON
            int current = 1;

            // Take the ASCII of the character from s and subtract with 97 to make it adjustable with 0-25 bit positions
            // Get the bit position and left shift it
            current = current << string.charAt(i) - 97;

            // check if the bit is already ON using Bitwise AND operator (aka Masking = find the bit is ON or not)
            // Which means it is already present and is duplicate
            if ((H & current) != 0) {
                System.out.printf("%c ", string.charAt(i));
                continue;
            }

            // if the bit was not ON already, make it ON by using Bitwise OR operator (aka Merging = to set the value)
            H = H | current;
        }
    }

    /*
    * Anagram, compare two strings having same alphabets but different words e.g. medical, decimal are anagram
    * This method works with distinct characters only
    * */
    public static boolean isAnagram(String str1, String str2) {
        // If it's a different size, two words cannot anagram
        if (str1.length() != str2.length()) return false;

        boolean[] hashTable = new boolean[128];

        // Mark the ASCII positions for str1
        for (int i = 0; i < str1.length(); i++) {
            hashTable[str1.charAt(i) - 97] = true;
        }

        // Check str2 that all the characters are marked as true in the hash table
        // If any character is not marked as true, then two words are not anagram
        for (int i = 0; i < str2.length(); i++) {
            if (!hashTable[str2.charAt(i) - 97]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
//        changeCase("WelcomE!!!aBc".toCharArray());
//        countVowelsAndConsonants(new char[]{'I', 'm', 'a', 'm', '!'});
//        countWords("Hello there, my name    is Imam Bux.");
//        reverseString("Imam");
        findDuplicatesForLowerCaseOnly("finding");
    }

}
