import java.util.*;

class GetLongestSubstringNotRepeatableChars {
    public static void main(String[] args) {
        GetLongestSubstringNotRepeatableChars s = new GetLongestSubstringNotRepeatableChars();
        int res = s.lengthOfLongestSubstring("dvvf");
    }

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int maxLen = 0;
        int len = s.length();

        for(int i = 0, j = 0; i < len; ++i){
            while(set.contains(s.charAt(i))){
                set.remove(s.charAt(j++));
            }

            set.add(s.charAt(i));
            maxLen = Math.max(set.size(), maxLen);
        }

        return maxLen;
    }
}

