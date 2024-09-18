package com.imambux.dsa;

public class DiagonalMatrix {
  int[] array;

  DiagonalMatrix(int size) {
    array = new int[size];
  }

  void set(int i, int j, int x) {
    if (i == j) {
      array[i] = x;
    }
  }

  int get(int i, int j) {
    if (i == j) {
      return array[i];
    }

    return 0;
  }

  void display() {
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array.length; j++) {
        if (i == j) {
          System.out.printf("%3d", array[i]);
        } else {
          System.out.printf("%3d", 0);
        }
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    DiagonalMatrix diagonalMatrix = new DiagonalMatrix(5);
    diagonalMatrix.set(0, 0, 1);
    diagonalMatrix.set(0, 2, 1);
    diagonalMatrix.set(1, 1, 2);
    diagonalMatrix.set(2, 2, 3);
    diagonalMatrix.set(3, 3, 4);
    diagonalMatrix.set(4, 4, 5);
    diagonalMatrix.display();

    System.out.println(diagonalMatrix.get(3, 3));
    System.out.println(diagonalMatrix.get(3, 4));
  }
}
