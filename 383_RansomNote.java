/*383. Ransom Note
Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the
letters from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.

Example 1:

Input: ransomNote = "a", magazine = "b"
Output: false
Example 2:

Input: ransomNote = "aa", magazine = "ab"
Output: false
Example 3:

Input: ransomNote = "aa", magazine = "aab"
Output: true
 */
import java.util.HashMap;

class Solution383 {
    public static void main(String[] args) {
        Solution383 s = new Solution383();
        System.out.println(s.canConstruct("aa", "aab"));
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> magMap = new HashMap<>();
        for (Character c : magazine.toCharArray()) {
            Integer repeats = magMap.get(c);
            if (null != repeats) {
                magMap.put(c, ++repeats);
            } else {
                magMap.put(c, 1);
            }
        }
        for (Character c : ransomNote.toCharArray()) {
            Integer repeats = magMap.get(c);
            if (null != repeats && repeats > 0) {
                magMap.put(c, repeats - 1);
            } else {
                return false;
            }
        }

        return true;
    }
}