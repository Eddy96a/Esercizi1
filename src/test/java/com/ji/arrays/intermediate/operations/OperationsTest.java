package com.ji.arrays.intermediate.operations;

import com.ji.arrays.intermediate.operations.Operations;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OperationsTest {

    private static final String TEST_NAME = "[OPERATIONS TEST]";
    private String message;
    private String result;
    private static float vote = 0;
    private Operations operations = null;

    public float round(float d, int decimalPlace) {
        BigDecimal bd = new BigDecimal(Float.toString(d));
        bd = bd.setScale(decimalPlace, RoundingMode.CEILING);
        return bd.floatValue();
    }

    @BeforeAll
    public void setUpClass() throws Exception {
        operations = new Operations();
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
    @DisplayName("[1] - Test equals")
    @Order(1)
    void testEquals(TestInfo info) {
        message = info.getDisplayName();
        result = "\t\t\t\t[FAIL]";
        int[] array1 = {1, 2, 3, 4};
        int[] array2 = {1, 2, 3, 4};
        boolean equals = operations.equals(array1, array2);
        assertTrue(equals);
        int[] array3 = {1, 2, 3, 4};
        int[] array4 = {1, 2, 3, 5};
        boolean equals2 = operations.equals(array3, array4);
        assertFalse(equals2);
        result = "\t\t\t\t[SUCCESS][+3.0]";
        vote += 3.0f;
    }

    @Test
    @DisplayName("[2] - Test shiftLeft")
    @Order(2)
    void shiftLeft(TestInfo info) {
        message = info.getDisplayName();
        result = "\t\t\t\t[FAIL]";
        int[] array = {1, 2, 3, 4};
        int[] shiftedArray = operations.shiftLeft(array);
        int[] expectedArray = {2, 3, 4, 1};
        int[] array2 = {1, 2, 3, 4, 5};
        int[] shiftedArray2 = operations.shiftLeft(array2);
        int[] expectedArray2 = {2, 3, 4, 5, 1};
        assertArrayEquals(expectedArray2, shiftedArray2);
        assertArrayEquals(expectedArray, shiftedArray);
        result = "\t\t\t\t[SUCCESS][+3.0]";
        vote += 5.0f;
    }

    @Test
    @DisplayName("[3] - Test shiftRight")
    @Order(3)
    void shiftRight(TestInfo info) {
        message = info.getDisplayName();
        result = "\t\t\t\t[FAIL]";
        int[] array = {1, 2, 3, 4};
        int[] shiftedArray = operations.shiftRight(array);
        int[] expectedArray = {4, 1, 2, 3};
        int[] array2 = {1, 2, 3, 4, 5};
        int[] shiftedArray2 = operations.shiftRight(array2);
        int[] expectedArray2 = {5, 1, 2, 3, 4};
        assertArrayEquals(expectedArray2, shiftedArray2);
        assertArrayEquals(expectedArray, shiftedArray);
        result = "\t\t\t[SUCCESS][+3.0]";
        vote += 5.0f;
    }

    @Test
    @DisplayName("[4] - Test swapHalves")
    @Order(4)
    void swapHalves(TestInfo info) {
        message = info.getDisplayName();
        result = "\t\t\t[FAIL]";
        int[] array = {1, 2, 3, 4};
        int[] swappedArray = operations.swapHalves(array);
        int[] expectedArray = {3, 4, 1, 2};
        assertArrayEquals(expectedArray, swappedArray);
        int[] array2 = {1, 2, 3, 4, 5};
        int[] swappedArray2 = operations.swapHalves(array2);
        assertNull(swappedArray2);
        result = "\t\t\t[SUCCESS][+3.0]";
        vote += 8.0f;
    }

    @Test
    @DisplayName("[5] - Test contains")
    @Order(5)
    void contains(TestInfo info) {
        message = info.getDisplayName();
        result = "\t\t\t\t[FAIL]";
        int[] array1 = {1, 2, 3, 4};
        int[] array2 = {1, 2};
        boolean contains = operations.contains(array2, array1);
        assertTrue(contains);
        int[] array3 = {1, 2, 3, 4};
        int[] array4 = {1, 5};
        boolean contains2 = operations.contains(array4, array3);
        assertFalse(contains2);
        result = "\t\t\t\t[SUCCESS][+3.0]";
        vote += 10.0f;
    }
}