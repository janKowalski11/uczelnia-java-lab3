package matrix;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MatrixTest {

    final Integer[][] TRIANGLE_SHAPE_ARR;

    final Integer[][] SQUARE_SHAPE_ARR;
    final int SQUARE_ARR_SIZE = 5;

    public MatrixTest() {
        TRIANGLE_SHAPE_ARR = new Integer[5][];
        for (int i = 0; i < TRIANGLE_SHAPE_ARR.length; i++) {
            TRIANGLE_SHAPE_ARR[i] = new Integer[i + 1];
        }

        //fills in TRIANGLE_SHAPE_ARR with some random values
        for (int i = 0; i < TRIANGLE_SHAPE_ARR.length; i++)
            for (int j = 0; j < TRIANGLE_SHAPE_ARR[i].length; j++)
                TRIANGLE_SHAPE_ARR[i][j] = j;

        SQUARE_SHAPE_ARR = new Integer[SQUARE_ARR_SIZE][];
        for (int i = 0; i < SQUARE_SHAPE_ARR.length; i++) {
            SQUARE_SHAPE_ARR[i] = new Integer[SQUARE_ARR_SIZE];
        }

        //fills in TRIANGLE_SHAPE_ARR with some random values
        for (int i = 0; i < SQUARE_SHAPE_ARR.length; i++)
            for (int j = 0; j < SQUARE_SHAPE_ARR[i].length; j++)
                SQUARE_SHAPE_ARR[i][j] = j;
    }


    //arr.clone doesnt work on 2d arrays
    private  Integer[][] clone2DimensionalArray(Integer[][] src) {
        int length = src.length;
        Integer[][] target = new Integer[length][src[0].length];
        for (int i = 0; i < length; i++) {
            System.arraycopy(src[i], 0, target[i], 0, src[i].length);
        }
        return target;
    }

    @Before
    public void setUp() throws Exception {

    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreatingMatrixWithWrongMatrix() {
        Matrix matrix = new Matrix(TRIANGLE_SHAPE_ARR);
    }

    @Test
    public void testCreatingMatrixWithProperMatrix() {
        Matrix matrix = new Matrix(SQUARE_SHAPE_ARR);
    }

    @Test
    public void testAddWrongMatrix() {
        Matrix matrix = new Matrix(SQUARE_SHAPE_ARR);
        assertNull(matrix.addMatrix(TRIANGLE_SHAPE_ARR));
    }

    @Test
    public void testAddProperMatrix() {
        Matrix<Integer> matrix = new Matrix(SQUARE_SHAPE_ARR);
        assertNotNull(matrix.addMatrix(SQUARE_SHAPE_ARR));
    }

    @Test
    public void testAddProperMatrixLong() {
        Long[][] arr = new Long[5][];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Long[5];
        }

        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[i].length; j++)
                arr[i][j] = Long.valueOf(i);

        Matrix<Long> matrix = new Matrix(arr);
        assertNotNull(matrix.addMatrix(arr));
    }

    @Test
    public void testAdding() {

        Integer[][] testArr=clone2DimensionalArray(SQUARE_SHAPE_ARR);

        Matrix<Integer> matrix = new Matrix<>(SQUARE_SHAPE_ARR);
        Integer[][] resArr = matrix.addMatrix(SQUARE_SHAPE_ARR);

        for (int i = 0; i < SQUARE_SHAPE_ARR.length; i++)
            for (int j = 0; j < SQUARE_SHAPE_ARR[i].length; j++)
                assertEquals(Integer.valueOf(testArr[i][j]+testArr[i][j]),
                        resArr[i][j]);
    }
}
