/*32. Longest Valid Parentheses
Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses 
substring

Example 1:

Input: s = "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()".
Example 2:

Input: s = ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()".
Example 3:

Input: s = ""
Output: 0
*/

import java.util.ArrayDeque;
import java.util.Deque;


public class Solution32 {
    public static void main(String[] args) {
        String s = "()(()()(()(";
        Solution32 sol = new Solution32();

        System.out.println(sol.longestValidParentheses(s));
    }
    public int longestValidParentheses(String s) {
        char[] strArr = s.toCharArray();
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int max = 0;
        for (int i = 0; i < strArr.length; ++i){
            if(strArr[i] == '('){
                stack.push(i);
            }else {
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else {
                    int curMax = i - stack.peek();
                    max = Math.max(max, curMax);
                }
            }
        }
        return max;
    }
}