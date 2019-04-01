package ex4;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class TargetTest {

    Target target;


    @Before
    public void setUp() throws Exception {
        target = new Target();
    }

    @Test
    public void testAverageCase() {
        int[] arr = Target.solution(new int[]{10, 2, 15, 7, 9}, 19);
        assertArrayEquals(new int[]{0, 4}, arr);

    }

    @Test(expected = IllegalArgumentException.class)
    public  void testCaseWithoutSolution() {

        int[] arr= Target.solution(new int[]{1,2}, 10);
    }

    @Test
    public void test() {
    }
}