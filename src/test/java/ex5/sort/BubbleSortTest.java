package ex5.sort;

import ex5.generator.ArrayGenerator;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static ex5.generator.ArrayGeneratorTest.isSortedAscending;
import static org.junit.Assert.assertTrue;

public class BubbleSortTest {

    int[] opt_arr;
    int[] pes_arr;
    int[] rand_arr;

    final int DEF_ARR_SIZE = 1000;

    final int DEF_TIME_FOR_CREATING_ARR=1;

    @Rule
    public Timeout globalTimeout = Timeout.seconds(1);// 1 seconds max per method tested


    private final BubbleSort sort = new BubbleSort();

    @Before
    public void setUp() throws Exception {
        opt_arr = ArrayGenerator.getOptimisticArray(DEF_ARR_SIZE);
        pes_arr = ArrayGenerator.getPessimisticArr(DEF_ARR_SIZE);
        rand_arr = ArrayGenerator.getRandomArr(DEF_ARR_SIZE);
    }

    @Test
    public void testAscendingSort() {
        sort.bubbleSort(opt_arr);
        assertTrue(isSortedAscending(opt_arr));
    }

    @Test
    public void testDescSort() {
        sort.bubbleSort(pes_arr);
        assertTrue(isSortedAscending(pes_arr));
    }

    @Test
    public void testRandArr() {
        sort.bubbleSort(rand_arr);
        assertTrue(isSortedAscending(rand_arr));
    }

    @Test(expected = NullPointerException.class)
    public  void  testNullArr(){
        sort.bubbleSort(null);
    }
}