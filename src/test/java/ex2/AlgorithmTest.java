package ex2;


import ex2.exceptions.ListToLongException;
import ex2.exceptions.ListValuesOutOfRange;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static ex2.Algorithm.solution;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

public class AlgorithmTest {

    @Mock
    List<Integer> nums;

    final int MAX_LIST_SIZE = 10000;
    final int SMALLEST_POSSIBLE_VALUE = -1000000;
    final int MAX_POSSIBLE_VALUE = 1000000;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test(expected = ListToLongException.class)
    public void testListToLongException() throws Exception {
        when(nums.size()).thenReturn(MAX_LIST_SIZE + 1);
        solution(nums);
    }

    @Test(expected = ListValuesOutOfRange.class)
    public void TestListValuesOutOfRangeExcElementTooSmall() throws Exception {
        when(nums.get(anyInt())).thenReturn(SMALLEST_POSSIBLE_VALUE - 1);
        solution(nums);
    }

    @Test(expected = ListValuesOutOfRange.class)
    public void TestListValuesOutOfRangeExcElementTooBig() throws Exception {
        when(nums.get(anyInt())).thenReturn(MAX_POSSIBLE_VALUE + 1);
        solution(nums);
    }

    @Test
    public void testAverageCase() throws Exception {
        final List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(3);
        nums.add(6);
        nums.add(4);
        nums.add(1);
        nums.add(2);

        assertEquals(5, solution(nums));
    }

    @Test
    public void testAscendingList() throws Exception {
        final List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        nums.add(5);

        assertEquals(6, solution(nums));
    }

    @Test
    public void testNegativeList() throws Exception{
        final List<Integer> nums = new ArrayList<>();
        nums.add(-1);
        nums.add(-2);
        nums.add(-3);
        nums.add(-4);
        nums.add(-5);

        assertEquals(1, solution(nums));
    }
}