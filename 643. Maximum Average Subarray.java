/*
You are given an integer array nums consisting of n elements, and an integer k.

Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.

 

Example 1:

Input: nums = [1,12,-5,-6,50,3], k = 4
Output: 12.75000
Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
Example 2:

Input: nums = [5], k = 1
Output: 5.00000

*/




class Solution {
        public double findMaxAverage(int[] nums, int k) {
        if(null == nums || nums.length < k) {
            return 0;
        }

        int leftIndex = 0;
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        for(int i = 0; i < nums.length; ++i) {
            currSum += nums[i];
            if(i >= k - 1) {
                maxSum = Math.max(maxSum, currSum);
                currSum -= nums[leftIndex++];
            }
        }

        return (double) maxSum / k;
    }
}
