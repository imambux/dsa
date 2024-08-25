package com.imambux.dsa;

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
            for (int i = length; i > index ; i--) {
                array[i] = array[i - 1];
            }
            array[index] = value;
            length++;
        }
    }

    public void delete(int index) {
        if (index >= 0 && index < length) {
            System.out.printf("Delete element at index %d", index);
            for (int i = index; i < length - 1; i++) {
                array[i] = array[i + 1];
            }
            length--;
        }
    }
}
