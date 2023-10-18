package com.ji.arrays.basic.finder;

import org.jinjection.ann.ConditionToExecute;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ConditionToExecute(classToCheck = Finder.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FinderTest {

    private static final String TEST_NAME = "[FINDER]";
    private String message;
    private String result;
    private static float vote = 0;
    private Finder finder = null;



    public float round(float d, int decimalPlace) {
        BigDecimal bd = new BigDecimal(Float.toString(d));
        bd = bd.setScale(decimalPlace, RoundingMode.CEILING);
        return bd.floatValue();
    }

    @BeforeAll
    public void setUpClass() throws Exception {
        finder = new Finder();
    }

    @AfterAll
    public void tearDownClass() throws Exception {
        System.out.println("\n\n===========================================================");
        if (vote > 30) {
            System.out.println("\t\t\tYOUR VOTE: 30 e Lode ! ");
        } else {
            System.out.println("\t\t\tYOUR VOTE: " + round(vote, 1) + "/30");
        }

        System.out.println("===========================================================\n\n");
    }

    @BeforeEach
    public void setUp() throws Exception {

    }

    @AfterEach
    public void tearDown() throws Exception {
        System.out.println(TEST_NAME + message + ": " + result);

    }



    @Test
    @DisplayName("[1] - Test find")
    @Order(1)
    void find(TestInfo info) {
        message = info.getDisplayName();
        result = "\t\t\t\t\t[FAIL]";
        int [] array = {1,2,3,4,5,6,7,8,9,10};
        int index = finder.find(array, 5);
        assertEquals(4, index, "The index of the first occurrence of the value in the array is not correct");

        int missingIndex = finder.find(array, 11);
        assertEquals(-1, missingIndex, "The index of the first occurrence of the value in the array is not correct");

        result = "\t\t\t\t\t[SUCCESS][+3.0]";
        vote += 3.0f;
    }

    @Test
    @DisplayName("[2] - Test checkAllPositive")
    @Order(2)
    void checkAllPositive(TestInfo info) {
        message = info.getDisplayName();
        result = "\t\t[FAIL]";
        int [] array = {1,2,3,4,5,6,7,8,9,10};
        boolean check = finder.checkAllPositive(array);
        assertTrue(check, "The array contains negative numbers");

        int [] array2 = {1,2,3,4,5,6,7,8,9,-10};
        boolean check2 = finder.checkAllPositive(array2);
        assertFalse(check2, "The array contains negative numbers");

        result = "\t\t[SUCCESS][+3.0]";
        vote += 3.0f;

    }

    @Test
    @DisplayName("[3] - Test findMax")
    @Order(3)
    void findMax() {
        message = "[3] - Test findMax";
        result = "\t\t\t\t[FAIL]";
        int [] array = {1,2,3,4,5,6,7,8,9,10};
        int max = finder.findMax(array);
        assertEquals(10, max, "The maximum value in the array is not correct");

        int [] array2 = {1,2,3,4,5,6,7,8,9,-10};
        int max2 = finder.findMax(array2);
        assertEquals(9, max2, "The maximum value in the array is not correct");

        result = "\t\t\t\t[SUCCESS][+5.0]";
        vote += 5.0f;
    }

    @Test
    @DisplayName("[4] - Test findMin")
    @Order(4)
    void findMin() {
        message = "[4] - Test findMin";
        result = "\t\t\t\t[FAIL]";
        int [] array = {1,2,3,4,5,6,7,8,9,10};
        int min = finder.findMin(array);
        assertEquals(1, min, "The minimum value in the array is not correct");

        int [] array2 = {1,2,3,4,5,6,7,8,9,-10};
        int min2 = finder.findMin(array2);
        assertEquals(-10, min2, "The minimum value in the array is not correct");

        result = "\t\t\t\t[SUCCESS][+5.0]";
        vote += 5.0f;
    }

    @Test
    @DisplayName("[5] - Test numberOfZeros")
    @Order(5)
    void numberOfZeros() {
        message = "[5] - Test numberOfZeros";
        result = "\t\t\t[FAIL]";
        int [] array = {1,2,3,4,5,6,7,8,9,10};
        int count = finder.numberOfZeros(array);
        assertEquals(0, count, "The number of zeros in the array is not correct");

        int [] array2 = {1,2,3,4,5,6,7,8,9,-10};
        int count2 = finder.numberOfZeros(array2);
        assertEquals(0, count2, "The number of zeros in the array is not correct");

        int [] array3 = {1,2,3,4,5,6,7,8,9,-10, 0};
        int count3 = finder.numberOfZeros(array3);
        assertEquals(1, count3, "The number of zeros in the array is not correct");

        result = "\t\t\t[SUCCESS][+4.0]";
        vote += 4.0f;
    }

    @Test
    @DisplayName("[6] - Test checkAllNegative")
    @Order(6)
    void checkAllNegative() {
        message = "[6] - Test checkAllNegative";
        result = "\t\t[FAIL]";
        int [] array = {1,2,3,4,5,6,7,8,9,10};
        boolean check = finder.checkAllNegative(array);
        assertFalse(check, "The array contains negative numbers");

        int [] array2 = {1,2,3,4,5,6,7,8,9,-10};
        boolean check2 = finder.checkAllNegative(array2);
        assertFalse(check2, "The array contains negative numbers");

        int [] array3 = {-1,-2,-3,-4,-5,-6,-7,-8,-9,-10};
        boolean check3 = finder.checkAllNegative(array3);
        assertTrue(check3, "The array contains negative numbers");

        result = "\t\t[SUCCESS][+5.0]";
        vote += 5.0f;
    }

    @Test
    @DisplayName("[7] - Test checkAllEven")
    @Order(7)
    void checkAllEven() {
        message = "[7] - Test checkAllEven";
        result = "\t\t\t[FAIL]";
        int [] array = {1,2,3,4,5,6,7,8,9,10};
        boolean check = finder.checkAllEven(array);
        assertFalse(check, "The array contains even numbers");

        int [] array2 = {1,2,3,4,5,6,7,8,9,-10};
        boolean check2 = finder.checkAllEven(array2);
        assertFalse(check2, "The array contains even numbers");

        int [] array3 = {-1,-2,-3,-4,-5,-6,-7,-8,-9,-10};
        boolean check3 = finder.checkAllEven(array3);
        assertFalse(check3, "The array contains even numbers");

        int [] array4 = {-1,-2,-3,-4,-5,-6,-7,-8,-9,-11};
        boolean check4 = finder.checkAllEven(array4);
        assertFalse(check4, "The array contains even numbers");

        int [] array5 = {2,4,6,8,10};
        boolean check5 = finder.checkAllEven(array5);
        assertTrue(check5, "The array contains even numbers");
        result = "\t\t\t[SUCCESS][+3.0]";
        vote += 3.0f;
    }

    @Test
    @DisplayName("[8] - Test checkAllOdd")
    @Order(8)
    void checkAllOdd() {
        message = "[8] - Test checkAllOdd";
        result = "\t\t\t[FAIL]";
        int [] array = {1,2,3,4,5,6,7,8,9,10};
        boolean check = finder.checkAllOdd(array);
        assertFalse(check, "The array contains odd numbers");

        int [] array2 = {1,2,3,4,5,6,7,8,9,-10};
        boolean check2 = finder.checkAllOdd(array2);
        assertFalse(check2, "The array contains odd numbers");

        int [] array3 = {-1,-2,-3,-4,-5,-6,-7,-8,-9,-10};
        boolean check3 = finder.checkAllOdd(array3);
        assertFalse(check3, "The array contains odd numbers");


        int [] array4 = {-1,-2,-3,-4,-5,-6,-7,-8,-9,-11};
        boolean check4 = finder.checkAllOdd(array4);
        assertFalse(check4, "The array contains even numbers");

        int [] array5 = {1,3,5,7,9};
        boolean check5 = finder.checkAllOdd(array5);
        assertTrue(check5, "The array contains odd numbers");
        result = "\t\t\t[SUCCESS][+3.0]";
        vote += 3.0f;
    }
}