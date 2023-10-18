package com.ji.arrays.basic.matrix;

import com.ji.arrays.basic.finder.Finder;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MatrixExplorerTest {

    private static final String TEST_NAME = "[MATRIX EXPLORER]";
    private String message;
    private String result;
    private static float vote = 0;
    private MatrixExplorer explorer = null;
    int [][] matrix;

    public float round(float d, int decimalPlace) {
        BigDecimal bd = new BigDecimal(Float.toString(d));
        bd = bd.setScale(decimalPlace, RoundingMode.CEILING);
        return bd.floatValue();
    }

    @BeforeAll
    public void setUpClass() throws Exception {
        explorer = new MatrixExplorer();
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
    @DisplayName("[1] - Test countZeroInMatrix")
    @Order(1)
    void countZeroInMatrix_base(TestInfo info) {

        message = info.getDisplayName();
        result = "\t\t\t\t[FAIL]";

        int count = explorer.countZeroInMatrix(matrix);
        assertEquals(0, count, "The number of zeros should be 0");
        matrix [0][0] = 0;
        count = explorer.countZeroInMatrix(matrix);
        assertEquals(1, count, "The number of zeros should be 1");
        matrix [0][1] = 0;
        count = explorer.countZeroInMatrix(matrix);
        assertEquals(2, count, "The number of zeros should be 2");

        //matrix of all zero
        matrix = new int[3][3];
        count = explorer.countZeroInMatrix(matrix);
        assertEquals(9, count, "The number of zeros should be 9");

        result = "\t\t\t\t[SUCCESS][+3.0]";
        vote += 3.0f;

    }

    @Test
    @DisplayName("[2] - Test sumAllNonZeroValuesInMatrix")
    @Order(2)
    void sumAllNonZeroValuesInMatrix(TestInfo info) {
        message = info.getDisplayName();
        result = "\t[FAIL]";

        int sum = explorer.sumAllNonZeroValuesInMatrix(matrix);
        assertEquals(45, sum, "The sum of all non zero values should be 45");
        matrix [0][0] = 0;

        sum = explorer.sumAllNonZeroValuesInMatrix(matrix);
        assertEquals(44, sum, "The sum of all non zero values should be 44");

        matrix [0][1] = 0;
        matrix [2][2] = 0;
        sum = explorer.sumAllNonZeroValuesInMatrix(matrix);
        assertEquals(33, sum, "The sum of all non zero values should be 43");

        //check with all zero matrix
        matrix = new int[3][3];
        sum = explorer.sumAllNonZeroValuesInMatrix(matrix);
        assertEquals(0, sum, "The sum of all non zero values should be 0");

        result = "\t[SUCCESS][+3.0]";
        vote += 3.0f;

    }

    @Test
    @DisplayName("[3] - Test checkAllPositive")
    @Order(3)
    void checkAllPositive(TestInfo info) {
        message = info.getDisplayName();
        result = "\t\t\t\t[FAIL]";

        boolean check = explorer.checkAllPositive(matrix);
        assertTrue(check, "The matrix does not contains any negative numbers");
        matrix [2][1] = -1;
        check = explorer.checkAllPositive(matrix);
        assertFalse(check, "The matrix contains negative numbers");

        result = "\t\t\t\t[SUCCESS][+4.0]";
        vote += 4.0f;

    }

    @Test
    @DisplayName("[4] - Test isSymmetric")
    @Order(4)
    void isSymmetric(TestInfo info) {
        message = info.getDisplayName();
        result = "\t\t\t\t\t[FAIL]";

        boolean check = explorer.isSymmetric(matrix);
        assertFalse(check, "The matrix is not symmetric");

        //overriding the matrix with a symmetric one
        matrix = new int[][]{{1,2,3},{2,4,5},{3,5,6}};
        check = explorer.isSymmetric(matrix);
        assertTrue(check, "The matrix is symmetric");

        result = "\t\t\t\t\t[SUCCESS][+6.0]";
        vote += 6.0f;
    }

    @Test
    @DisplayName("[5] - Test sumOfDiagonal")
    @Order(5)
    void sumOfDiagonal(TestInfo info) {
        message = info.getDisplayName();
        result = "\t\t\t\t\t[FAIL]";

        int sum = explorer.sumOfDiagonal(matrix);
        assertEquals(15, sum, "The sum of the diagonal should be 15");

        //overriding the matrix with a symmetric one
        matrix = new int[][]{{1,2,3},{2,4,5},{3,5,6}};
        sum = explorer.sumOfDiagonal(matrix);
        assertEquals(11, sum, "The sum of the diagonal should be 11");

        result = "\t\t\t\t\t[SUCCESS][+4.0]";
        vote += 4.0f;
    }

    @Test
    @DisplayName("[6] - Test sum of two matrices")
    @Order(6)
    void sum(TestInfo info){
        message = info.getDisplayName();
        result = "\t\t\t[FAIL]";

        // 1 2 3      1 2 3     2 4 6
        // 4 5 6   +  2 4 5  =  6 9 11
        // 7 8 9      3 5 6     10 13 15

        int [][] matrix2 = new int[][]{{1,2,3},{2,4,5},{3,5,6}};
        int [][] sum = explorer.sum(matrix, matrix2);
        assertEquals(2, sum[0][0], "The sum of the two matrices is not correct");
        assertEquals(4, sum[0][1], "The sum of the two matrices is not correct");
        assertEquals(6, sum[0][2], "The sum of the two matrices is not correct");
        assertEquals(6, sum[1][0], "The sum of the two matrices is not correct");
        assertEquals(9, sum[1][1], "The sum of the two matrices is not correct");
        assertEquals(11, sum[1][2], "The sum of the two matrices is not correct");
        assertEquals(10, sum[2][0], "The sum of the two matrices is not correct");
        assertEquals(13, sum[2][1], "The sum of the two matrices is not correct");
        assertEquals(15, sum[2][2], "The sum of the two matrices is not correct");

        result = "\t\t\t[SUCCESS][+5.0]";
        vote += 5.0f;
    }

    @Test
    @DisplayName("[7] - Test setRowToZero")
    @Order(7)
    void setRowToZero(TestInfo info){
        message = info.getDisplayName();
        result = "\t\t\t\t\t[FAIL]";

        boolean valid1 = explorer.setRowToZero(matrix, -1);
        assertFalse(valid1, "The method should return true if the row is out of bounds");

        boolean valid2 = explorer.setRowToZero(matrix, 3);
        assertFalse(valid2, "The method should return true if the row is out of bounds");

        boolean valid3 = explorer.setRowToZero(matrix, 1);
        assertEquals(1, matrix[0][0], "The row should be set to zero");
        assertEquals(2, matrix[0][1], "The row should be set to zero");
        assertEquals(3, matrix[0][2], "The row should be set to zero");
        assertEquals(0, matrix[1][0], "The row should be set to zero");
        assertEquals(0, matrix[1][1], "The row should be set to zero");
        assertEquals(0, matrix[1][2], "The row should be set to zero");
        assertEquals(7, matrix[2][0], "The row should be set to zero");
        assertEquals(8, matrix[2][1], "The row should be set to zero");
        assertEquals(9, matrix[2][2], "The row should be set to zero");

        assertTrue(valid3, "The method should return true if the row is valid");

        result = "\t\t\t\t\t[SUCCESS][+6.0]";
        vote += 6.0f;


    }
}