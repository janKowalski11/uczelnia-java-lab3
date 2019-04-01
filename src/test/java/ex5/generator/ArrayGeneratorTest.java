package ex5.generator;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ArrayGeneratorTest {

    int[] opt_arr;
    int[] pes_arr;
    int[] rand_arr;

    final int DEF_ARR_SIZE = 9999999;

    final int DEF_TIME_FOR_CREATING_ARR=1;

    @Rule
    public Timeout globalTimeout = Timeout.seconds(1);// 1 seconds max per method tested

    public static boolean isSortedAscending(int[] arr) {

        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i + 1] < arr[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isSortedDescending(int[] arr) {

        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i + 1] > arr[i]) {
                return false;
            }
        }
        return true;
    }

    @Before
    public void setUp() throws Exception {
        opt_arr = ArrayGenerator.getOptimisticArray(DEF_ARR_SIZE);
        pes_arr = ArrayGenerator.getPessimisticArr(DEF_ARR_SIZE);
        rand_arr = ArrayGenerator.getRandomArr(DEF_ARR_SIZE);
    }

    @Test
    public void testGetAscendingArr() {
        assertTrue(isSortedAscending(opt_arr));
    }

    @Test
    public void testDescendingArr() {
        assertTrue(isSortedDescending(pes_arr));
    }

    @Test
    public void testRandomArray() {
        assertFalse(isSortedDescending(rand_arr));
        assertFalse(isSortedAscending(rand_arr));
    }
}