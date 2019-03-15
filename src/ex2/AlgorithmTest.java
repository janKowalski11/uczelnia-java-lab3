package ex2;
/*
Author: BeGieU
Date: 15.03.2019
*/

import ex2.exceptions.ListToLongException;
import ex2.exceptions.ListValuesOutOfRange;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AlgorithmTest
{
    public static void test1Ex() throws ListToLongException, ListValuesOutOfRange
    {
        final List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(3);
        nums.add(6);
        nums.add(4);
        nums.add(1);
        nums.add(2);
        System.out.println("SOLUTION:  " + Algorithm.solution(nums));
        for (int n : nums)
            System.out.println(n);
    }

    public static void test2Ex() throws ListToLongException, ListValuesOutOfRange
    {
        final List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        System.out.println("SOLUTION:  " + Algorithm.solution(nums));
        for (int n : nums)
            System.out.println(n);
    }

    public static void test3Ex() throws ListToLongException, ListValuesOutOfRange
    {
        final List<Integer> nums = new ArrayList<>();
        nums.add(-1);
        nums.add(-3);
        System.out.println("SOLUTION:  " + Algorithm.solution(nums));
        for (int n : nums)
            System.out.println(n);
    }

    public static void test4RandomNumbers() throws ListToLongException, ListValuesOutOfRange
    {
        Random rand = new Random();
        final List<Integer> nums = new ArrayList<>();

        for (int i = 0; i < 20; i++) // ads 20 random numbers to the list
        {
            int n = rand.nextInt(100) + 1; // range between 1-100
            nums.add(n);
        }

        System.out.println("SOLUTION:  " + Algorithm.solution(nums));
        for (int n : nums)
            System.out.println(n);
    }

    public static void test5RandomNegativeNums() throws ListToLongException, ListValuesOutOfRange
    {
        Random rand = new Random();
        final List<Integer> nums = new ArrayList<>();

        for (int i = 0; i < 20; i++) // ads 20 random numbers to the list
        {
            int n = -rand.nextInt(100) + 1; // range between (-1)   and  (-100)
            nums.add(n);
        }

        System.out.println("SOLUTION:  " + Algorithm.solution(nums));
        for (int n : nums)
            System.out.println(n);
    }

    public static void main(String[] args) throws ListToLongException, ListValuesOutOfRange
    {
        test5RandomNegativeNums();
    }
}
