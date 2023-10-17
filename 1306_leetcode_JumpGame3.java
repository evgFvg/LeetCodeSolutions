/*1306. Jump Game III
Medium
4K
94
Companies
Given an array of non-negative integers arr, you are initially positioned at start index of the array. When you are at index i, you can jump to i + arr[i] or i - arr[i], check if you can reach any index with value 0.

Notice that you can not jump outside of the array at any time.

 

Example 1:

Input: arr = [4,2,3,0,3,1,2], start = 5
Output: true
Explanation: 
All possible ways to reach at index 3 with value 0 are: 
index 5 -> index 4 -> index 1 -> index 3 
index 5 -> index 6 -> index 4 -> index 1 -> index 3 
Example 2:

Input: arr = [4,2,3,0,3,1,2], start = 0
Output: true 
Explanation: 
One possible way to reach at index 3 with value 0 is: 
index 0 -> index 4 -> index 1 -> index 3
Example 3:

Input: arr = [3,0,2,1,2], start = 2
Output: false
Explanation: There is no way to reach at index 1 with value 0.*/

class Solution {
    public boolean canReach(int[] arr, int start) {
    if (null == arr || start > arr.length - 1) {
            return false;
        }
        return recCanJump(arr, start, 0);
    }

    private boolean recCanJump(int[] arr, int i, int count) {
        if (i < 0 || i >= arr.length || count >= arr.length || arr[i] < 0) {
            return false;
        }
        if (0 == arr[i]) {
            return true;
        }
        int tmpIndexValue = arr[i];
        arr[i] = -1; //sign visited cell

        return recCanJump(arr, i + tmpIndexValue, count + 1) ||
                recCanJump(arr, i - tmpIndexValue, count + 1);
    }
}
