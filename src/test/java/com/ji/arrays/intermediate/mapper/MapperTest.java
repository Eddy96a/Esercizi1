package com.ji.arrays.intermediate.mapper;

import com.ji.arrays.basic.matrix.MatrixExplorer;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MapperTest {

    private static final String TEST_NAME = "[MAPPER TEST]";
    private String message;
    private String result;
    private static float vote = 0;
    private Mapper mapper = null;

    int [][] matrix;

    public float round(float d, int decimalPlace) {
        BigDecimal bd = new BigDecimal(Float.toString(d));
        bd = bd.setScale(decimalPlace, RoundingMode.CEILING);
        return bd.floatValue();
    }

    @BeforeAll
    public void setUpClass() throws Exception {
        mapper = new Mapper();
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
        matrix = new int[3][3];
        int k = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = ++k;
            }
        }

    }

    @AfterEach
    public void tearDown() throws Exception {
        System.out.println(TEST_NAME + message + ": " + result);

    }


    @Test
    @DisplayName("[1] - Test initStartPosition (normal flow)")
    @Order(1)
    void initStartPosition_normal_flow(TestInfo info) {
        message = info.getDisplayName();
        result = "\t[FAIL]";
        int[][] matrix = mapper.initStartPosition(3);

        int[][] expectedResult = new int[][]{{0, 0, 0}, {0, 2, 0}, {0, 0, 0}};
        assertArrayEquals(expectedResult, matrix);

        int[][] matrix2 = mapper.initStartPosition(7);

        int[][] expectedResult2 = new int[][]{{0, 0, 0, 0, 0, 0, 0},
                                              {0, 0, 0, 0, 0, 0, 0},
                                              {0, 0, 0, 0, 0, 0, 0},
                                              {0, 0, 0, 2, 0, 0, 0},
                                              {0, 0, 0, 0, 0, 0, 0},
                                              {0, 0, 0, 0, 0, 0, 0},
                                              {0, 0, 0, 0, 0, 0, 0}};
        assertArrayEquals(expectedResult2, matrix2);

        result = "\t[SUCCESS][+1.0]";
        vote += 3.0f;
    }

    @Test
    @DisplayName("[1] - Test initStartPosition (error flow)")
    @Order(2)
    void initStartPosition_error_flow(TestInfo info) {
        message = info.getDisplayName();
        result = "\t[FAIL]";
        int[][] matrix = mapper.initStartPosition(4);
        assertNull(matrix, "Matrix with n even should be null");

        int[][] matrix2 = mapper.initStartPosition(0);
        assertNull(matrix2, "Matrix with n = 0 should be null");

        int[][] matrix3 = mapper.initStartPosition(-1);
        assertNull(matrix3, "Matrix with n < 0 should be null");

        result = "\t[SUCCESS][+2.0]";
        vote += 2.0f;

    }



    @Test
    @DisplayName("[3] - Test extractMinorDiagonal")
    @Order(3)
    void extractMinorDiagonal(TestInfo info) {
        message = info.getDisplayName();
        result = "\t\t\t\t[FAIL]";
        int[] minorDiagonal = mapper.extractMinorDiagonal(matrix);
        int[] expectedResult = new int[]{3, 5, 7};
        assertArrayEquals(expectedResult, minorDiagonal);

        int[][] matrix2 = new int[][]{
                {1, 2, 3, 4,   5,  6,  7},
                {4, 5, 6, 7,   8,  9, 10},
                {7, 8, 9, 10, 11, 12, 13},
                {7, 8, 9, 10, 11, 12, 13},
                {7, 8, 9, 10, 11, 12, 13},
                {7, 8, 9, 10, 11, 12, 13},
                {7, 8, 9, 10, 11, 12, 13}};
        int[] minorDiagonal2 = mapper.extractMinorDiagonal(matrix2);
        int[] expectedResult2 = new int[]{7, 9, 11, 10, 9, 8, 7};
        assertArrayEquals(expectedResult2, minorDiagonal2);

        result = "\t\t\t\t[SUCCESS][+3.0]";
        vote += 3.0f;
    }

    @Test
    @DisplayName("[4] - Test findMaxHeavyRow")
    @Order(4)
    void findMaxHeavyRow(TestInfo info) {
        message = info.getDisplayName();
        result = "\t\t\t\t\t[FAIL]";
        int maxHeavyRow = mapper.findMaxHeavyRow(matrix);
        assertEquals(2, maxHeavyRow, "The max heavy row should be 2");

        int[][] matrix2 = new int[][]{
                {1, 2, 3, 4,   5,  6,  7},
                {4, 5, 6, 7,   8,  9, 10},
                {7, 8, 9, 10, 11, 12, 13},
                {7, 8, 9, 10, 11, 12, 13},
                {7, 8, 9, 100, 11, 12, 13},
                {7, 8, 9, 10, 11, 12, 13},
                {7, 8, 9, 10, 11, 12, 13}};
        int maxHeavyRow2 = mapper.findMaxHeavyRow(matrix2);
        assertEquals(4, maxHeavyRow2, "The max heavy row should be 4");

        result = "\t\t\t\t\t[SUCCESS][+4.0]";
        vote += 4.0f;
    }

    @Test
    @DisplayName("[5] - Test swapColumns")
    @Order(5)
    void swapColumns(TestInfo info) {
        message = info.getDisplayName();
        result = "\t\t\t\t\t\t[FAIL]";
        boolean swapped = mapper.swapColumns(matrix, 0, 2);
        assertTrue(swapped, "The columns should be swapped");
        int[][] expectedResult = new int[][]{{3, 2, 1}, {6, 5, 4}, {9, 8, 7}};
        assertArrayEquals(expectedResult, matrix);

        boolean swapped2 = mapper.swapColumns(matrix, 0, 0);
        assertFalse(swapped2, "The columns should not be swapped");
        assertArrayEquals(expectedResult, matrix);

        boolean swapped3 = mapper.swapColumns(matrix, 0, 3);
        assertFalse(swapped3, "The columns should not be swapped");
        assertArrayEquals(expectedResult, matrix);

        result = "\t\t\t\t\t\t[SUCCESS][+3.0]";
        vote += 3.0f;
    }

    @Test
    @DisplayName("[6] - checkIfExists (check rows)")
    @Order(6)
    void checkIfExists_rows(TestInfo info) {
        message = info.getDisplayName();
        result = "\t\t\t\t[FAIL]";
        int[] existingRow = new int[]{1, 2, 3};
        boolean exists = mapper.checkIfExists(matrix, existingRow);
        assertTrue(exists, "The row [1, 2, 3] should exist");

        int[] existingRow2 = new int[]{4, 5, 6};
        boolean exists2 = mapper.checkIfExists(matrix, existingRow2);
        assertTrue(exists2, "The row [4, 5, 6] should exist");

        int[] existingRow3 = new int[]{7, 8, 9};
        boolean exists3 = mapper.checkIfExists(matrix, existingRow3);
        assertTrue(exists3, "The row [7, 8, 9] should exist");

        int[] notExistingRow = new int[]{1, 2, 4};
        boolean exists4 = mapper.checkIfExists(matrix, notExistingRow);
        assertFalse(exists4, "The row [1, 2, 4] should not exist");

        int[] notExistingRow2 = new int[]{1, 2, 3, 4};
        boolean exists5 = mapper.checkIfExists(matrix, notExistingRow2);
        assertFalse(exists5, "The row [1, 2, 3, 4] should not exist");

        int[] notExistingRow3 = new int[]{1, 2};
        boolean exists6 = mapper.checkIfExists(matrix, notExistingRow3);
        assertFalse(exists6, "The row [1, 2] should not exist");

        result = "\t\t\t\t[SUCCESS][+3.0]";
        vote += 3.0f;

    }

    @Test
    @DisplayName("[7] - checkIfExists (check columns)")
    @Order(7)
    void checkIfExists(TestInfo info) {
        message = info.getDisplayName();
        result = "\t\t\t[FAIL]";
        int[] existingColumn = new int[]{1, 4, 7};
        boolean exists = mapper.checkIfExists(matrix, existingColumn);
        assertTrue(exists, "The column [1, 4, 7] should exist");

        int[] existingColumn2 = new int[]{2, 5, 8};
        boolean exists2 = mapper.checkIfExists(matrix, existingColumn2);
        assertTrue(exists2, "The column [2, 5, 8] should exist");

        int[] existingColumn3 = new int[]{3, 6, 9};
        boolean exists3 = mapper.checkIfExists(matrix, existingColumn3);
        assertTrue(exists3, "The column [3, 6, 9] should exist");

        int[] notExistingColumn = new int[]{1, 4, 8};
        boolean exists4 = mapper.checkIfExists(matrix, notExistingColumn);
        assertFalse(exists4, "The column [1, 4, 8] should not exist");

        int[] notExistingColumn2 = new int[]{1, 4, 7, 8};
        boolean exists5 = mapper.checkIfExists(matrix, notExistingColumn2);
        assertFalse(exists5, "The column [1, 4, 7, 8] should not exist");

        int[] notExistingColumn3 = new int[]{1, 4};
        boolean exists6 = mapper.checkIfExists(matrix, notExistingColumn3);
        assertFalse(exists6, "The column [1, 4] should not exist");

        result = "\t\t\t[SUCCESS][+3.0]";
        vote += 3.0f;

    }

    @Test
    @DisplayName("[8] - isFreePath (normal flow)")
    @Order(8)
    void isFreePath_normalFlow(TestInfo info) {
        message = info.getDisplayName();
        result = "\t\t\t\t[FAIL]";
        int[][] matrix = new int[][]{
                {0, 0, 0, 1, 0, 0, 0},
                {0, 8, 0, 0, 0, 0, 0},
                {3, 0, 0, 1, 4, 0, 0},
                {0, 0, 0, 2, 0, 0, 7},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 8, 0, 0, 0, 5, 0}};
        boolean freePath = mapper.isFreePath(matrix, 3, 3, 3, 6);
        assertTrue(freePath, "The path should be free");

        boolean freePath2 = mapper.isFreePath(matrix, 2, 0, 2, 3);
        assertTrue(freePath2, "The path should be free");

        boolean freePath3 = mapper.isFreePath(matrix, 6,1, 6, 5);
        assertTrue(freePath3, "The path should be free");

        boolean freePath4 = mapper.isFreePath(matrix, 1, 1, 6, 3);
        assertFalse(freePath4, "The path should be free");

        boolean freePath5 = mapper.isFreePath(matrix, 0, 3, 2, 3);
        assertTrue(freePath5, "The path should be free");

        boolean freePath6 = mapper.isFreePath(matrix, 3, 3, 0, 5);
        assertFalse(freePath6, "The path should not be free");

        boolean freePath7 = mapper.isFreePath(matrix, 3, 0, 3, 4);
        assertFalse(freePath7, "The path doest not start from any block");

        boolean freePath8 = mapper.isFreePath(matrix, 0, 3, 3, 3);
        assertFalse(freePath8, "The  path should not be free");

        result = "\t\t\t\t[SUCCESS][+7.0]";
        vote += 7.0f;
    }

    @Test
    @DisplayName("[9] - isFreePath (error flow)")
    @Order(9)
    void isFreePath_error_Flow(TestInfo info){
        message = info.getDisplayName();
        result = "\t\t\t\t[FAIL]";
        int[][] matrix = new int[][]{
                {0, 0, 0, 1, 0, 0, 0},
                {0, 8, 0, 0, 0, 0, 0},
                {3, 0, 0, 1, 4, 0, 0},
                {0, 0, 0, 2, 0, 0, 7},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 8, 0, 0, 0, 5, 0}};

        //test with coordinates out of bounds
        boolean freePath = mapper.isFreePath(matrix, 3, 3, 3, 7);
        assertFalse(freePath, "The input coordinates are out of bounds");

        boolean freePath2 = mapper.isFreePath(matrix, 3, 3, 7, 3);
        assertFalse(freePath2, "The input coordinates are out of bounds");

        boolean freePath3 = mapper.isFreePath(matrix, 3, 7, 3, 3);
        assertFalse(freePath3, "The input coordinates are out of bounds");

        boolean freePath4 = mapper.isFreePath(matrix, 7, 3, 3, 3);
        assertFalse(freePath4, "The input coordinates are out of bounds");

        //test with coordinates that do not start from a block
        boolean freePath5 = mapper.isFreePath(matrix, 0, 0, 0, 3);
        assertFalse(freePath5, "The path doest not start from any block");

        //test with coordinates that ends to a non-block
        boolean freePath6 = mapper.isFreePath(matrix, 2, 4, 5, 4);
        assertFalse(freePath6, "The path doest not end to any block");

        result = "\t\t\t\t[SUCCESS][+3.0]";
        vote += 3.0f;

    }
}