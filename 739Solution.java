/*739. Daily Temperatures

Given an array of integers temperatures represents the daily temperatures,
return an array answer such that answer[i] is the number of days you have to wait 
after the ith day to get a warmer temperature. If there is no future day for which
this is possible, keep answer[i] == 0 instead.

Example 1:

Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]
Example 2:

Input: temperatures = [30,40,50,60]
Output: [1,1,1,0]
Example 3:

Input: temperatures = [30,60,90]
Output: [1,1,0]
*/

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution739 {
    public static void main(String[] args) {
        Solution739 s = new Solution739();
        int[] arr = {13, 12, 15, 11, 9, 12, 16};
        int[] res = s.smartSolution(arr);
        System.out.println(Arrays.toString(res));
    }

    public int[] brutForce(int[] temperatures) {
        if (temperatures == null) {
            return new int[]{};
        }
        int[] res = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; ++i) {
            for (int j = i + 1; j < temperatures.length; ++j) {
                if (temperatures[i] < temperatures[j]) {
                    res[i] = j - i;
                    break;
                }
            }
        }
        return res;
    }

    public int[] smartSolution(int[] temperatures) {
        class DayStat {
            private final int temperature;
            private final int day;

            DayStat(int temperature, int day) {
                this.temperature = temperature;
                this.day = day;
            }
        }

        Deque<DayStat> aux = new ArrayDeque<>();
        int[] res = new int[temperatures.length];
        for (int i = temperatures.length - 1; i >= 0; --i) {
            while (!aux.isEmpty() && aux.peek().temperature <= temperatures[i]) {
                aux.pop();
            }
            if(!aux.isEmpty()){
                res[i] = aux.peek().day - i;
            }
            aux.push(new DayStat(temperatures[i], i));
        }
        return res;
    }
}