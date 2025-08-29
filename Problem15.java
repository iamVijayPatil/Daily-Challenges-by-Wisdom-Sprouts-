/*
Problem : Find the Longest Substring Without Repeating Characters
You are given a string S, and your task is to find the length of the longest substring that contains no repeating characters. A substring is a contiguous block of characters in the string.
In this problem, you need to find the length of the longest substring where all the characters are unique. The substring can be formed by starting at any position in the string, but it must not contain any repeated characters.

Input :
* A string S, where 1≤∣S∣≤105(length of string).
* Input: S = "abcabcbb"

Output :
An integer representing the length of the longest substring without repeating characters.
Output: 3

 */
import java.util.HashSet;

public class Problem15 {

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s)); // Output: 3
    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int left = 0, right = 0, maxLen = 0;

        HashSet<Character> set = new HashSet<>();
        while (right < n) {
            // If character is not in set, add it and expand window
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                maxLen = Math.max(maxLen, right - left + 1);
                right++;
            } else {
                // If duplicate, shrink window from left
                set.remove(s.charAt(left));
                left++;
            }
        }
        return maxLen;
    }
}
