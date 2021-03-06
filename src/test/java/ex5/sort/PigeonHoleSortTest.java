package ex5.sort;

import ex5.generator.ArrayGenerator;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static ex5.generator.ArrayGeneratorTest.isSortedAscending;
import static org.junit.Assert.assertTrue;

public class PigeonHoleSortTest {
    int[] opt_arr;
    int[] pes_arr;
    int[] rand_arr;

    final int DEF_ARR_SIZE = 100;

    final int DEF_TIME_FOR_CREATING_ARR=1;

    @Rule
    public Timeout globalTimeout = Timeout.seconds(1);// 1 seconds max per method tested

    private final PigeonHoleSort sort = new PigeonHoleSort();

    @Before
    public void setUp() throws Exception {
        opt_arr = ArrayGenerator.getOptimisticArray(DEF_ARR_SIZE);
        pes_arr = ArrayGenerator.getPessimisticArr(DEF_ARR_SIZE);
        rand_arr = ArrayGenerator.getRandomArr(DEF_ARR_SIZE);
    }

    @Test
    public void testAscendingSort() {
        sort.pigeonhole_sort(opt_arr,opt_arr.length);
        assertTrue(isSortedAscending(opt_arr));
    }

    @Test
    public void testDescSort() {
        sort.pigeonhole_sort(pes_arr,pes_arr.length);
        assertTrue(isSortedAscending(pes_arr));
    }

    @Test
    public void testRandArr() {
        sort.pigeonhole_sort(rand_arr,rand_arr.length);
        assertTrue(isSortedAscending(rand_arr));
    }
    @Test(expected = NullPointerException.class)
    public  void  testNullArr(){
        sort.pigeonhole_sort(null,0);
    }
}