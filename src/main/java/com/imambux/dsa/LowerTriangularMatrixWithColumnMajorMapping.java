package com.imambux.dsa;

public class LowerTriangularMatrixWithColumnMajorMapping {


  int[] array;
  int dimension;

  LowerTriangularMatrixWithColumnMajorMapping(int size) {
    dimension = size;
    array = new int[size * (size + 1) / 2];
  }

  void set(int i, int j, int x) {
    if (i >= j) {
      array[(dimension * (j - 1) - ((j - 2) * (j - 1)) / 2) + i - j] = x;
    }
  }

  int get(int i, int j) {
    if (i >= j) {
      return array[(dimension * (j - 1) - ((j - 2) * (j - 1)) / 2) + i - j];
    }

    return 0;
  }

  void display() {
    for (int i = 1; i <= dimension; i++) {
      for (int j = 1; j <= dimension; j++) {
        if (i >= j) {
          System.out.printf("%5d", array[(dimension * (j - 1) - ((j - 2) * (j - 1)) / 2) + i - j]);
        } else {
          System.out.printf("%5d", 0);
        }
      }

      System.out.println();
    }
  }

  public static void main(String[] args) {
    LowerTriangularMatrixWithColumnMajorMapping lowerTriangularMatrixWithColumnMajorMapping = new LowerTriangularMatrixWithColumnMajorMapping(5);
    lowerTriangularMatrixWithColumnMajorMapping.set(1, 1, 1);
    lowerTriangularMatrixWithColumnMajorMapping.set(2, 1, 2);
    lowerTriangularMatrixWithColumnMajorMapping.set(2, 2, 3);
    lowerTriangularMatrixWithColumnMajorMapping.set(3, 1, 4);
    lowerTriangularMatrixWithColumnMajorMapping.set(3, 2, 5);
    lowerTriangularMatrixWithColumnMajorMapping.set(3, 3, 6);
    lowerTriangularMatrixWithColumnMajorMapping.set(4, 1, 7);
    lowerTriangularMatrixWithColumnMajorMapping.set(4, 2, 8);
    lowerTriangularMatrixWithColumnMajorMapping.set(4, 3, 9);
    lowerTriangularMatrixWithColumnMajorMapping.set(4, 4, 10);
    lowerTriangularMatrixWithColumnMajorMapping.set(5, 1, 11);
    lowerTriangularMatrixWithColumnMajorMapping.set(5, 2, 12);
    lowerTriangularMatrixWithColumnMajorMapping.set(5, 3, 13);
    lowerTriangularMatrixWithColumnMajorMapping.set(5, 4, 14);
    lowerTriangularMatrixWithColumnMajorMapping.set(5, 5, 15);
    lowerTriangularMatrixWithColumnMajorMapping.set(1, 2, 1);

    lowerTriangularMatrixWithColumnMajorMapping.display();

    System.out.println(lowerTriangularMatrixWithColumnMajorMapping.get(5, 5));
  }

}
