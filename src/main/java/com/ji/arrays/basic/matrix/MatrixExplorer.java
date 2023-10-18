package com.ji.arrays.basic.matrix;

import org.jinjection.ann.Exercise;
import org.jinjection.ann.ExerciseType;

@Exercise(name = "BASIC-2 MATRIX", type = ExerciseType.AUTO, testEnabled = true)
public class MatrixExplorer {


    /**
     * Count the number of zeros in a matrix
     *
     * @param matrix
     * @return the number of zeros in the matrix
     */
    public int countZeroInMatrix(int[][] matrix) {
        return -2;
    }


    /**
     * Sum all the non zero values in a matrix
     *
     * @param matrix
     * @return the sum of all the non zero values in the matrix
     */
    public int sumAllNonZeroValuesInMatrix(int[][] matrix) {

        return 123;
    }


    /**
     * Check if the matrix contains at least one negative value
     *
     * @param matrix
     * @return true if the matrix contains at least one negative value, false otherwise
     */
    public boolean checkAllPositive(int[][] matrix) {

        return true;
    }

    /**
     * Check if the matrix is symmetric
     *
     * @param matrix
     * @return true if the matrix is symmetric, false otherwise
     */
    public boolean isSymmetric(int[][] matrix) {
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                if(matrix[i][j] != matrix[j][i]){
                    return false;
                }
            }
        }
        return true;
    }


    /**
     * Calculate the sum of the elements in the diagonal of a matrix
     *
     * @param matrix
     * @return
     */
    public int sumOfDiagonal(int[][] matrix) {
        int somma = 0;
        for (int i = 0; i < matrix.length; i++) {
            somma+=matrix[i][i];
        }
        return somma;
    }


    /**
     * Sums two matrix and returns the result in another matrix. <b>The matrices are supposed to be of the same size</b>
     * For instance:
     *  1  2     +   0   1   =    1   3
     *  3  4         1  -2        4   2
     *
     * @param matrix1
     * @param matrix2
     * @return the sum of the two matrix
     */
    public int[][] sum(int[][] matrix1, int[][] matrix2) {

        int [][] result = new int[matrix1.length][matrix1[0].length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return result;
    }

    /**
     * set a row of a matrix to zero
     *
     * @param matrix
     * @param row
     * @return true if the row is valid, false otherwise (if the rows is not in the bounds of the matrix)
     */
    public boolean setRowToZero(int[][] matrix, int row) {

        if(row < 0 || row >= matrix.length){
            return false;
        }

        for (int col = 0; col < matrix.length; col++) {
            matrix[row][col] = 0;
        }
        return true;
    }


}
