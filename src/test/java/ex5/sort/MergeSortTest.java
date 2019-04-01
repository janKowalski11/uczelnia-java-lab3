package ex5.sort;

import ex5.generator.ArrayGenerator;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static ex5.generator.ArrayGeneratorTest.isSortedAscending;
import static org.junit.Assert.assertTrue;

public class MergeSortTest {

    int[] opt_arr;
    int[] pes_arr;
    int[] rand_arr;

    final int DEF_ARR_SIZE = 100;

    final int DEF_TIME_FOR_CREATING_ARR=1;

    @Rule
    public Timeout globalTimeout = Timeout.seconds(1);// 1 seconds max per method tested

    private final MergeSort sort = new MergeSort();

    @Before
    public void setUp() throws Exception {
        opt_arr = ArrayGenerator.getOptimisticArray(DEF_ARR_SIZE);
        pes_arr = ArrayGenerator.getPessimisticArr(DEF_ARR_SIZE);
        rand_arr = ArrayGenerator.getRandomArr(DEF_ARR_SIZE);
    }

    @Test
    public void testAscendingSort() {
        sort.sort(opt_arr,0,opt_arr.length-1);
        assertTrue(isSortedAscending(opt_arr));
    }

    @Test
    public void testDescSort() {
        sort.sort(pes_arr,0,opt_arr.length-1);
        assertTrue(isSortedAscending(pes_arr));
    }

    @Test
    public void testRandArr() {
        sort.sort(rand_arr,0,opt_arr.length-1);
        assertTrue(isSortedAscending(rand_arr));
    }

    @Test
    public  void  testWrongIndexes(){
        sort.sort(null,-2,-3);

    }

    @Test(expected = StackOverflowError.class)
    public  void  testWrongIndexes2(){
        sort.sort(null,-2,0);

    }


}