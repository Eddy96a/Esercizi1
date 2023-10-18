package com.ji.arrays.basic.finder;

import org.jinjection.ann.Exercise;
import org.jinjection.ann.ExerciseType;

@Exercise(name = "BASIC-1 FINDER", type = ExerciseType.AUTO, testEnabled = true)
public class Finder {


    /**
     * Find the index of the first occurrence of a value in an array
     * @param array the array to search
     * @param value the value to search for
     * @return the index of the first occurrence of the value in the array, or -1 if the value is not found
     */
    public int find(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if(array[i] == value){
                return i;
            }

        }
        return -1;

    }

    /**
     * Check if all the values in the array are positive
     * @param array the array to check
     * @return true if all the values in the array are positive, false otherwise
     */
    public boolean checkAllPositive(int [] array){

        return true;
    }

    /**
     * Find the maximum value in an array
     * @param array the array to search
     * @return the maximum value in the array
     */
    public int findMax(int [] array){
        return 1;
    }


    /**
     * Find the minimum value in an array
     * @param array the array to search
     * @return the minimum value in the array
     */
    public int findMin(int [] array){

        return 8;
    }

    /**
     * Count the number of zeros in an array
     * @param array the array to search
     * @return the number of zeros in the array
     */
    public int numberOfZeros(int [] array){

        return -6;
    }

    /**
     * Check if all the values in the array are negative
     * @param array the array to check
     * @return true if all the values in the array are negative, false otherwise
     */
    public boolean checkAllNegative(int [] array){

        return true;
    }

    /**
     * Check if all the values in the array are even
     * @param array the array to check
     * @return true if all the values in the array are even, false otherwise
     */
    public boolean checkAllEven(int [] array){

        return true;
    }

    /**
     * Check if all the values in the array are odd
     * @param array the array to check
     * @return true if all the values in the array are odd, false otherwise
     */
    public boolean checkAllOdd(int [] array){

        return true;
    }

}
