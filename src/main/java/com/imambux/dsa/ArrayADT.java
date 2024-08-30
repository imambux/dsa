package com.imambux.dsa;

import com.imambux.dsa.util.Util;

public class ArrayADT {

    private int array[];
    // capacity
    private int size;
    // number of elements
    private int length;

    public ArrayADT(int[] elements, int size) {
        this.size = size;
        this.array = new int[size];
        for (int i = 0; i < elements.length; i++) {
            this.array[i] = elements[i];
        }
        this.length = elements.length;
    }

    public void display() {
        System.out.println("Display elements");
        for (int i = 0; i < length; i++) {
            System.out.printf("%d ", array[i]);
        }
        System.out.println();
        System.out.println();
        System.out.println();
    }

    public void append(int x) {
        if (length < size) {
            System.out.printf("Append %d%n", x);
            array[length++] = x;
        }
    }

    public void insert(int value, int index) {
        if (index >= 0 && index <= length) {
            System.out.printf("Insert %d at index %d%n", value, index);
            for (int i = length; i > index; i--) {
                array[i] = array[i - 1];
            }
            array[index] = value;
            length++;
        }
    }

    public int delete(int index) {
        if (index >= 0 && index < length) {
            int deletedValue = array[index];
            System.out.printf("Delete element at index %d", index);
            for (int i = index; i < length - 1; i++) {
                array[i] = array[i + 1];
            }
            length--;

            return deletedValue;
        }

        return 0;
    }

    /*
    * O(n)
    */
    public int linearSearch(int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }

        return -1;
    }

    /*
     * O(n)
     * Improving Linear Search by Transposition
     * Transposition = If the value is search repeatedly, move it close by swapping to reduce the number of steps
     * to search for it the next time
     */
    public int linearSearchByTransposition(int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                // Transposition: swap the value to the forward position to find it faster (one less step) the next time
                if (i > 0) {
                    int temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                    return i - 1;
                }
                return i;
            }
        }

        return -1;
    }

    /*
     * O(n)
     * Improving Linear Search by Move to Head/Front Technique
     * Move to Front = If the value is searched and found, move it the front by swapping the value with index 0
     */
    public int linearSearchByMoveToHead(int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                // Move to front: swap the value to the front position at index 0
                if (i > 0) {
                    int temp = array[i];
                    array[i] = array[0];
                    array[0] = temp;
                    return 0;
                }
                return i;
            }
        }

        return -1;
    }

    /*
    * Binary search algorithm works on the sorted array only
    * O(log n)
    * */
    public int binarySearch(int value) {
        // set 3 indices required for binary search
        int low = 0;
        int high = length - 1;
        int mid;

        // loop until mid is not equal to the value or low index is not higher than the high index
        while (low <= high) {
            // with new low and high set new mid index
            mid = (low + high) / 2;

            // check if value is found in the mid
            if (array[mid] == value) {
                return mid;
            }

            // if value is still not found in the mid then adust the indices for low or high
            if (value < array[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    /*
     * Binary search algorithm works on the sorted array only
     * This uses tail recursion. Always prefer loop to tail recursion because that is easy to implement and
     * also avoid stack
     * */
    public int rBinarySearch(int low, int high, int value) {
        // if done with all the elements, then exit with -1 to indicate the value is not found
        if (low >= high) return -1;

        // with valid low and high, find a mid and check with the value
        int mid = (low + high) / 2;
        if (array[mid] == value) return mid;

        // if the value is still not found in the mid, then adjust the indices for low or high
        if (value < array[mid]) {
            return rBinarySearch(low, mid - 1, value);
        } else {
            return rBinarySearch(mid + 1, high, value);
        }
    }

    public int get(int index) {
        if (index >= 0 && index < length) {
            return array[index];
        }

        return -1;
    }

    public void set(int value, int index) {
        if (index >= 0 && index < length) {
            array[index] = value;
        }
    }

    public int max() {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        return max;
    }

    public int min() {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }

        return min;
    }

    public int sum() {
        int total = 0;
        for (int i = 0; i < array.length; i++) {
            total += array[i];
        }

        return total;
    }

    public int average() {
        return sum() / length;
    }

    /*
    * Method 1
    * Take an auxiliary array and copy the elements of the original array in reverse.
    * Copy the auxiliary array (with reversed values) back into the original array.
    * TC = 2n (two loops) = O(n)
    * */
    public void reverseWithAuxiliaryArray() {
        int[] auxiliaryArray = new int[length];

        // reverse loop over the original array and copy each element in the auxiliary array
        for (int i = length - 1, j = 0; i >= 0; i--, j++) {
            auxiliaryArray[j] = array[i];
        }

        // copy the reverse elements of an auxiliary array back in the original array
        for (int i = 0; i < length; i++) {
            array[i] = auxiliaryArray[i];
        }
    }

    /*
    * Method 2:
    * In a loop iterate i and j until i < j and swap the values using i and j indices
    * TC = O(log n) // probably
    * */
    public void reverse() {
        // reverse loop over the original array and copy each element in the auxiliary array
        for (int i = 0, j = length - 1; i < j; i++, j--) {
            Util.swap(array, i, j);
        }
    }

    public void leftShift() {

        for (int i = 0; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }

        array[length - 1] = 0;
    }

    public void leftRotate() {
        int firstValue = array[0];

        for (int i = 0; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }

        array[length - 1] = firstValue;
    }

    public void rightRotate() {
        int lastValue = array[length - 1];

        for (int i = length - 1; i > 0; i--) {
            array[i] = array[i - 1];
        }

        array[0] = lastValue;
    }

    public void rightShift() {
        for (int i = length - 1; i > 0; i--) {
            array[i] = array[i - 1];
        }

        array[0] = 0;
    }

    public void insertInSortedArray(int x) {
        if (!isSorted()) {
            return;
        }

        int i = length - 1;

        while (array[i] >= x) {
            array[i + 1] = array[i];
            i--;
        }

        array[i + 1] = x;
        length++;
    }

    public boolean isSorted() {
        for (int i = 0; i < length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }

        return true;
    }

    /*
    * O(n^2)
    * */
    public void negativeElementsOntheLeft() {
        for (int i = 0; i < length - 1; i++) {
            if (array[i] >= 0) {
                for (int j = i + 1; j < length; j++) {
                    if (array[j] < 0) {
                        Util.swap(array, i, j);
                        break;
                    }
                }
            }
        }
    }

    /*
     * O(3n) = O(n)
     * */
    public void negativeElementsOntheLeft2() {
        int[] allNegatives = new int[length];
        int[] allPositives = new int[length];

        // get all positives
        for (int i = 0, j = 0; i < length; i++) {
            if (array[i] < 0) {
                allNegatives[j] = array[i];
                j++;
            }
        }

        // get all negatives
        for (int i = 0, j = 0; i < length; i++) {
            if (array[i] >= 0) {
                allPositives[j] = array[i];
                j++;
            }
        }

        for (int i = 0, n = 0, p = 0; i < length; i++) {
            if (allNegatives[i] < 0) {
                array[i] = allNegatives[n];
                n++;
            } else {
                array[i] = allPositives[p];
                p++;
            }
        }
    }

    /*
    * TC = O(n)
    * Better solution compared to the others
    * Only using one loop
    * */
    public void negativeElementsOntheLeft3() {
        for (int i = 0, j = length - 1; i < j;) {
            // if the value at i is negative, then move to the next element
            if (array[i] < 0) {
                i++;
                continue;
            }

            // if the value at is positive then find the negative value in element from the end of the list
            if (array[j] >= 0) {
                j--;
                continue;
            }

            // if the value at i is positive and j is negative, then swap
            Util.swap(array, i, j);
        }
    }
}
