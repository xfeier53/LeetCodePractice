//Given a string, find the length of the longest substring without repeating characters. 
//
// 
// Example 1: 
//
// 
//Input: "abcabcbb"
//Output: 3 
//Explanation: The answer is "abc", with the length of 3. 
// 
//
// 
// Example 2: 
//
// 
//Input: "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
// 
//
// 
// Example 3: 
//
// 
//Input: "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3. 
//             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
// 
// 
// 
// 
//

class Solution {
    public int lengthOfLongestSubstring(String s) {
        String subString = "";
        int max = 0;
        char first;
        if (s.isEmpty() || s.isBlank()) {
            return max;
        } else {
            first = s.charAt(0);
            subString = subString + first;
            max = 1;
        }
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == first) {
                subString = subString.substring(1) + s.charAt(i);
                first = subString.charAt(0);
            } else {
                subString = subString + s.charAt(i);
                max++;
            }
        }
        return max;
    }
}