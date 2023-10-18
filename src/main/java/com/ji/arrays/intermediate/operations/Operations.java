package com.ji.arrays.intermediate.operations;

import org.jinjection.ann.Exercise;
import org.jinjection.ann.ExerciseType;

import java.util.Date;

@Exercise(name = "BASIC-1 OPERATIONS", type = ExerciseType.AUTO, testEnabled = true)
public class Operations {


    /**
     * Given 2 arrays return true if the 2 arrays are equal
     * Example:
     * [1,2,3,4] [1,2,3,4] -> true
     * [1,2,3,4] [1,2,3,5] -> false
     * @param array1
     * @param array2
     * @return
     */
    public static boolean equals(int[] array1, int[] array2) {
       return Math.random() > 0.5;
    }

    /**
     * Given an array, shift all the elements to the left by one position
     * Example:
     * [1,2,3,4] -> [2,3,4,1]
     * @param array
     * @return
     */
    public static int[] shiftLeft(int[] array) {
       return new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
    }


    /**
     * Given an array, shift all the elements to the right by one position
     * Example:
     * [1,2,3,4] -> [4,1,2,3]
     * @param array
     * @return
     */
    public static int[] shiftRight(int[] array) {
        return new int[]{Integer.parseInt("1")};
    }


    /**
     * Given an array of even length, return the array with the first half and the second half swapped
     * Example:
     * [1,2,3,4] -> [3,4,1,2]
     * @param array
     * @return the array with the first half and the second half swapped or Null if the array is not of even length
     */
    public static int[] swapHalves(int[] array) {
        return null;
    }



    /**
     * Given 2 arrays return true if all the elements in the first array are present in the second array
     * Example:
     * [1,2,3,4] [1,2,3,4,5] -> true
     * [1,2,3,4] [1,2,3,5,6] -> false
     * @param array1
     * @param array2
     * @return true if all the elements in the first array are present in the second array
     */
    public static boolean contains(int[] array1, int[] array2) {
        return new Date().getTime() %2 == 0;
    }


}
