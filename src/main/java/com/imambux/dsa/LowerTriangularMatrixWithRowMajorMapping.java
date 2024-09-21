package com.imambux.dsa;

public class LowerTriangularMatrixWithRowMajorMapping {

  int[] array;
  int dimension;

  LowerTriangularMatrixWithRowMajorMapping(int size) {
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
    LowerTriangularMatrixWithRowMajorMapping lowerTriangularMatrixWithRowMajorMapping = new LowerTriangularMatrixWithRowMajorMapping(5);
    lowerTriangularMatrixWithRowMajorMapping.set(1, 1, 1);
    lowerTriangularMatrixWithRowMajorMapping.set(2, 1, 2);
    lowerTriangularMatrixWithRowMajorMapping.set(2, 2, 3);
    lowerTriangularMatrixWithRowMajorMapping.set(3, 1, 4);
    lowerTriangularMatrixWithRowMajorMapping.set(3, 2, 5);
    lowerTriangularMatrixWithRowMajorMapping.set(3, 3, 6);
    lowerTriangularMatrixWithRowMajorMapping.set(4, 1, 7);
    lowerTriangularMatrixWithRowMajorMapping.set(4, 2, 8);
    lowerTriangularMatrixWithRowMajorMapping.set(4, 3, 9);
    lowerTriangularMatrixWithRowMajorMapping.set(4, 4, 10);
    lowerTriangularMatrixWithRowMajorMapping.set(5, 1, 11);
    lowerTriangularMatrixWithRowMajorMapping.set(5, 2, 12);
    lowerTriangularMatrixWithRowMajorMapping.set(5, 3, 13);
    lowerTriangularMatrixWithRowMajorMapping.set(5, 4, 14);
    lowerTriangularMatrixWithRowMajorMapping.set(5, 5, 15);
    lowerTriangularMatrixWithRowMajorMapping.set(1, 2, 1);

    lowerTriangularMatrixWithRowMajorMapping.display();

    System.out.println(lowerTriangularMatrixWithRowMajorMapping.get(5, 5));
  }

}
