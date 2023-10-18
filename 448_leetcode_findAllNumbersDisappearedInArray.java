/*448. Find All Numbers Disappeared in an Array

Given an array nums of n integers where nums[i] is in the range [1, n],
 return an array of all the integers in the range [1, n] that do not appear in nums.


Example 1:

Input: nums = [4,3,2,7,8,2,3,1]
Output: [5,6]
Example 2:

Input: nums = [1,1]
Output: [2]

 

Follow up: Could you do it without extra space and in O(n) runtime? 
You may assume the returned list does not count as extra space.*/

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int i = 0 ;
        List<Integer> ans = new ArrayList<>();
        
        while(i < nums.length){
            int correctIndex = nums[i] - 1;
            if(nums[i] != nums[correctIndex]){
                swap(nums, i , correctIndex);
            }else {
                ++i;
            }
        }
        
        for(i = 0; i < nums.length; ++i){
            if(nums[i] != i + 1){
                ans.add(i + 1);
            }
        }

        return ans;
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
