/*64. Minimum Path Sum

Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

 

Example 1:

Input: grid = [[1,3,1],
	       [1,5,1],
	       [4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
Example 2:

Input: grid = [[1,2,3],
	       [4,5,6]]
Output: 12
*/

class Solution {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        for(int i = 1; i < col; ++i){
            grid[0][i] += grid[0][i - 1];
        }
        for(int j = 1; j < row; ++j){
            grid[j][0] += grid[j - 1][0];
        }
        for(int i = 1; i < row; ++i){
            for(int j = 1; j < col; ++j){
                grid[i][j] += Math.min(grid[i][j - 1], grid[i - 1][j]);
            }
        }

        return grid[row - 1][col - 1];
    }
}
