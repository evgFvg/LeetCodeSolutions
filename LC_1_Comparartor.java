/*
179. Largest Number

Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.

Since the result may be very large, so you need to return a string instead of an integer.

 

Example 1:

Input: nums = [10,2]
Output: "210"
Example 2:

Input: nums = [3,30,34,5,9]
Output: "9534330"*/

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        final int[] arr = {3,30,34,5,9};
        System.out.println(getLargestNumber(arr));
    }


    public static String getLargestNumber(int[] arr) {
        return IntStream.of(arr)
                .boxed()
                .map(Object::toString)
                .sorted((a,b)->(b+a).compareTo(a + b))
                .collect(Collectors.joining());
    }
}

