package ex2;
/*
Author: BeGieU
Date: 15.03.2019
*/

import ex2.exceptions.ListToLongException;
import ex2.exceptions.ListValuesOutOfRange;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*solution method finds smallest positive number which is not present int the given list*/
public class Algorithm
{

    //works properly only on sorted list !!!
    private static boolean checkList(List<Integer> nums) throws ListToLongException,ListValuesOutOfRange
    {
        if (!(nums.size() < 10000)) //satisfy given requirement: solution supports only lists smaller than 1e5
        {
            throw new ListToLongException("given list is to long: " + nums.toString());
        }
        else if (nums.get(0) < -1000000) //embrace  feature of sorted list(smallest el at index 0)
        {
            throw new ListValuesOutOfRange("given list's argument of index: " + 0 +" is  smaller than -100000");
        }
        else if (nums.get(nums.size() - 1) > 1000000)
        {
            throw new ListValuesOutOfRange("given list's argument of index: " + (nums.size() - 1) +" is  bigger than 100000");
        }
        return true;
    }

    public static int solution(List<Integer> nums) throws ListToLongException, ListValuesOutOfRange
    {
        nums.sort(Comparator.naturalOrder());

        Algorithm.checkList(nums);


        boolean growing = true; // if true then i+1th number is always bigger than i by ONE
        int result = Integer.MIN_VALUE;

        for (int i = 1; i < nums.size(); i++)
        {
            int diff = nums.get(i) - nums.get(i - 1); //diff between two adjacent numbers
            if (diff > 1)
            {
                result = nums.get(i - 1) + 1;
                growing = false;
                break;
            }
        }

        if (growing)
        {
            // given list's numbers are growing by one(growing flag is set on true)
            // then we take last value from list and add one
            result = nums.get(nums.size() - 1) + 1;
        }

        //deals with exercise requirements, that it has to return smallest POSITIVE value
        if (result <= 0)
        {
            result = 1;
        }

        return result;
    }

    public static void main(String[] args) throws ListToLongException , ListValuesOutOfRange
    {
        final List<Integer> nums = new ArrayList<>();

        System.out.println("SOLUTION:  " + Algorithm.solution(nums));
        for (int n : nums)
            System.out.println(n);
    }
}
