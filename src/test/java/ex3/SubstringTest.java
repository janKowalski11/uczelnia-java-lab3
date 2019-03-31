package ex3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SubstringTest {

    Substring substring;

    @Before
    public void setUp() throws Exception {
        substring = new Substring();
    }

    @Test
    public void test1() {
        assertEquals(3, substring.substring("abcd", "cdabcdab"));
    }

    @Test
    public void test2() {
       assertEquals(4,substring.substring("abcd", "bcdabcdabcdab"));
        //returned value should be equal to 4
    }

    @Test
    public void test3() {
        assertEquals(1,substring.substring("abcd", "abcd"));
        //returned value should be equal to 1
    }

    @Test
    public void test4() {
        assertEquals(-1,substring.substring("abcd", "abc"));
        //returned value should be equal to -1
    }

    @Test
    public void test5() {
        assertEquals(2,substring.substring("abcd", "abcda"));
        //returned value should be equal to 2
    }

    @Test
    public void test6() {
        assertEquals(2,substring.substring("abcd", "dabcd"));
        //returned value should be equal to 2
    }
}