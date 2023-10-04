/*Given an array of integers nums and an integer k,
return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.

Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2
 */

import java.util.HashMap;


public class Solution560 {
    public static void main(String[] args) {
        Solution560 s = new Solution560();
        int[] arr = {4,2,2,1,2,-3,5,-8};
        System.out.println(s.smartSolution(arr, 5));
    }
    public int brutForce(int[] arr, int k) {
        int count = 0;
        int sum = 0;

        for(int i = 0; i < arr.length; ++i){
            for(int j = i; j < arr.length; ++j){
                sum += arr[j];
                if(sum == k) {
                    ++count;
                }
            }
            sum = 0;
        }
        return count;
    }

    public int smartSolution(int[] arr, int k) {
        int count = 0;
        int sum = 0;
        HashMap<Integer, Integer> subArraySums = new HashMap<>();
        subArraySums.put(0, 1);
        for (int j : arr) {
            sum += j;
            Integer val = subArraySums.get(sum - k);
            if (null != val) {
                count += val;
            }
            subArraySums.merge(sum, 1, Integer::sum); // if map doesn't have such a key: value 1 associated with the key
            // otherwise biFunction takes place: the previous value is added to 1
            //and key(sum) associated with the new value (prev + 1);
        }
        return count;
    }
}