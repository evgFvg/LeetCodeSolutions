/*485. Max Consecutive Ones
Given a binary array nums, return the maximum number of consecutive 1's in the array.

Example 1:

Input: nums = [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
Example 2:

Input: nums = [1,0,1,1,0,1]
Output: 2
 
*/

class Solution485 {
    public static void main(String[] args) {
        int[] arr = {1,1,0,1,1,1};
        Solution485 s = new Solution485();
        System.out.println(s.findMaxConsecutiveOnes(arr));
    }
    public int findMaxConsecutiveOnes(int[] nums) {
        if(null == nums){
            return 0;
        }
        int sum = 0;
        int maxSum = 0;
        for(int i = 0; i < nums.length; ++i){
            sum = nums[i] == 0 ? 0 : ++sum;
            maxSum = Math.max(maxSum, sum);

        }
        return maxSum;
    }
}