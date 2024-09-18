package com.imambux.dsa;

public class LowerTriangularMatrix {

  int[] array;
  int dimension;

  LowerTriangularMatrix(int size) {
    dimension = size;
    array = new int[size * (size + 1) / 2];
  }

  void set(int i, int j, int x) {
    if (i >= j) {
      array[i * (i - 1) / 2 + j - 1] = x;
    }
  }

  int get(int i, int j) {
    if (i >= j) {
      return array[i * (i - 1) / 2 + j - 1];
    }

    return 0;
  }

  void display() {
    for (int i = 1; i <= dimension; i++) {
      for (int j = 1; j <= dimension; j++) {
        if (i >= j) {
          System.out.printf("%5d", array[i * (i - 1) / 2 + j - 1]);
        } else {
          System.out.printf("%5d", 0);
        }
      }

      System.out.println();
    }
  }

  public static void main(String[] args) {
    LowerTriangularMatrix lowerTriangularMatrix = new LowerTriangularMatrix(5);
    lowerTriangularMatrix.set(1, 1, 1);
    lowerTriangularMatrix.set(2, 1, 2);
    lowerTriangularMatrix.set(2, 2, 3);
    lowerTriangularMatrix.set(3, 1, 4);
    lowerTriangularMatrix.set(3, 2, 5);
    lowerTriangularMatrix.set(3, 3, 6);
    lowerTriangularMatrix.set(4, 1, 7);
    lowerTriangularMatrix.set(4, 2, 8);
    lowerTriangularMatrix.set(4, 3, 9);
    lowerTriangularMatrix.set(4, 4, 10);
    lowerTriangularMatrix.set(5, 1, 11);
    lowerTriangularMatrix.set(5, 2, 12);
    lowerTriangularMatrix.set(5, 3, 13);
    lowerTriangularMatrix.set(5, 4, 14);
    lowerTriangularMatrix.set(5, 5, 15);
    lowerTriangularMatrix.set(1, 2, 1);

    lowerTriangularMatrix.display();

    System.out.println(lowerTriangularMatrix.get(5, 5));
  }

}
