/*1833. Maximum Ice Cream Bars
It is a sweltering summer day, and a boy wants to buy some ice cream bars.

At the store, there are n ice cream bars. You are given an array costs of length n,
where costs[i] is the price of the ith ice cream bar in coins.
 The boy initially has coins coins to spend, and he wants to buy as many ice cream bars as possible.

Note: The boy can buy the ice cream bars in any order.

Return the maximum number of ice cream bars the boy can buy with coins coins.

You must solve the problem by counting sort.

Example 1:

Input: costs = [1,3,2,4,1], coins = 7
Output: 4
Explanation: The boy can buy ice cream bars at indices 0,1,2,4 for a total price of 1 + 3 + 2 + 1 = 7.
Example 2:

Input: costs = [10,6,8,7,7,8], coins = 5
Output: 0
Explanation: The boy cannot afford any of the ice cream bars.
Example 3:

Input: costs = [1,6,3,1,2,5], coins = 20
Output: 6
Explanation: The boy can buy all the ice cream bars for a total price of 1 + 6 + 3 + 1 + 2 + 5 = 18.
*/

public class Solution1833 {
    public static void main(String[] args) {
        Solution1833 s = new Solution1833();
        int[] arr = {4, 3, 1, -2, 8, 0, 1, 4, 4};
        s.maxIceCream(arr, 5);
    }

    public int maxIceCream(int[] costs, int coins) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int cost : costs) {
            min = Math.min(min, cost);
            max = Math.max(max, cost);
        }

        int[] priceCounts = getPriceCounts(costs, min, max);
        sortCosts(costs, priceCounts, min);


        return countIceCreamBars(costs, coins);
    }

    private int countIceCreamBars(int[] costs, int coins) {
        for(int i = 0; i < costs.length; ++i){
            if((coins -= costs[i]) < 0){
                return i;
            }
        }
        return costs.length;
    }

    private void sortCosts(int[] costs, int[] priceCounts, int min) {
        for (int i = 0, j = 0; i < priceCounts.length; ++i) {
            while (priceCounts[i] > 0) {
                costs[j] = i + min;
                ++j;
                --priceCounts[i];
            }
        }
    }

    private int[] getPriceCounts(int[] costs, int min, int max) {
        int[] res = new int[max - min + 1];
        for (int cost : costs) {
            res[cost - min]++;
        }
        return res;
    }
}
