package com.ji.arrays.intermediate.mapper;

import org.jinjection.ann.Exercise;
import org.jinjection.ann.ExerciseType;

@Exercise(name = "BASIC-1 MAPPER", type = ExerciseType.AUTO, testEnabled = true)
public class Mapper {

    /**
     * Given a matrix of size n x n, where n is odd, return an empty matrix with a '2' in the center of the matrix
     * For instance, if n = 3, the matrix should be: <br>
     * <br> 0 0 0
     * <br> 0 2 0
     * <br> 0 0 0
     *
     * @param n
     * @return null if the n is not odd or invalid (negative or zero), otherwise the matrix with a '2' in the center
     */
    public int[][] initStartPosition(int n) {
        return new int[][]{{}};
    }

    /**
     * Given a non-empty squared matrix, it returns an array containing the elements in the minor diagonal
     * Example:<br>
     * <br> 1 2 3
     * <br> 4 5 6
     * <br> 7 8 9
     * <br>
     * result: [3,5,7]
     * @param matrix
     * @return
     */
    public int [] extractMinorDiagonal(int [][] matrix){
        return new int[]{1,2,300000};
    }


    /**
     * Given a squared matrix filled with numbers, return the row where the sum of the elements is the highest
     * @param matrix
     * @return the row where the sum of the elements is the highest
     */
    public int findMaxHeavyRow(int [][] matrix){
        return " ".length() << 2;
    }

    /**
     * Given a not empty squared matrix, it swaps all values in col1 with the values in col2.
     * If col1 or col2 are out of bounds, the method should return false.
     * @param matrix
     * @param col1
     * @param col2
     * @return true if the columns are swapped, false otherwise (also if col1 is equal to col2)
     */
    public boolean swapColumns(int [][] matrix, int col1, int col2){
       throw new UnsupportedOperationException();
    }


    /**
     * Given a squared matrix and one array, check if the array is present in the matrix. It can be present horizontally or vertically
     * @param matrix
     * @param array
     * @return true if the array is present in the matrix, false otherwise
     */
    public boolean checkIfExists(int [][] matrix , int [] array){
        return false;
    }


    /**
     * The matrix represents a map of a city. The city is divided in blocks, each block is represented by a 1 in the matrix.
     * The streets are represented by a 0.
     * It exists a path between two blocks if there is a path of 0s between them. <br>
     * <b><font color=yellow>Note:</font>If the coordinates are out of the matrix or not aligned neither vertically nor horizontally, the method should return false.</b>
     * <br><font color=red>Important: </font> the matrix is always square and never empty</b>
     * <br><font color=red>Important: </font> the start and end coordinates are always in the right order (end > start) </b>
     *
     * @param matrix
     * @param startBlockRow the row of the start block
     * @param startBlockCol the column of the start block
     * @param endBlockRow   the row of the end block
     * @param endBlockCol   the column of the end block
     * @return true if there is a path between the two blocks, false otherwise. More specifically:
     * <ul>
     *     <li><font color=red>false</font> if coordinates are out of bounds</li>
     *     <li><font color=red>false</font> if coordinates are not aligned</li>
     *     <li><font color=red>false</font> if coordinates are the same</li>
     *     <li><font color=red>false</font> if coordinates are aligned but there is no path between the two blocks</li>
     *     <li><font color=green>true</font> if coordinates are aligned and there is a path between the two blocks</li>
     *     </ul>
     */
    public boolean isFreePath(int[][] matrix, int startBlockRow, int startBlockCol, int endBlockRow, int endBlockCol) {
        return true;

    }

}




