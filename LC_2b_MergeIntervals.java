/*
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

 
Example 1:
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].


Example 2:
Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
*/




class Solution {
    public int[][] merge(int[][] intervals) {
                List<int[]> resList = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int from = intervals[0][0];
        int to = intervals[0][1];
        for(int i = 1; i < intervals.length; ++i) {
            if(intervals[i][0] <= to) {
                to = Math.max(to, intervals[i][1]);
            }else {
                resList.add(new int[]{from, to});
                from = intervals[i][0];
                to = intervals[i][1];
            }
        }
        resList.add(new int[]{from,to});
        return resList.toArray(new int[resList.size()][]);
    }
}
