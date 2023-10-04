/*200. Number of Islands
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water),
 return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1

Example 2:
Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
*/
public class Solution200 {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        for(int i = 0; i < row; ++i){
            for(int j = 0; j < col; ++j){
                if(grid[i][j] == '1'){
                    ++count;
                    sinkIsland(grid, i, j);
                }
            }
        }

        return count;
    }

    private void sinkIsland(char[][] grid, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0' ){
            return;
        }
        grid[i][j] = '0';
        sinkIsland(grid, i + 1, j);
        sinkIsland(grid, i, j + 1);
        sinkIsland(grid, i - 1, j);
        sinkIsland(grid, i, j - 1);
    }
}