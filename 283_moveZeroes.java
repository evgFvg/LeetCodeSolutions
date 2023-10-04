/*283. Move Zeroes

Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

 

Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
Example 2:

Input: nums = [0]
Output: [0]*/

import java.util.Arrays;

public class Solution283{
    public static void main(String[] args) {
        int[] arr = {1,0,0,3,2,0};
        Solution283 s = new Solution283();
        s.moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }
    public void moveZeroes(int[] nums) {
        if(null == nums || nums.length < 2){
            return;
        }
        int nonZeroIndex = 0;
        for(int i = 0; i < nums.length; ++i){
            if(nums[i] != 0){
                if(i != nonZeroIndex){
                    swap(nums, nonZeroIndex, i);
                }
                nonZeroIndex++;
            }
        }
    }

    private void swap(int[] nums, int lhs, int rhs){
        int temp = nums[lhs];
        nums[lhs] = nums[rhs];
        nums[rhs] = temp;
    }
}