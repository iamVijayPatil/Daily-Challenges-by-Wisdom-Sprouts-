/*Day 13 of 30 🗓

Problem : Longest Palindromic Substring
You are given a string s. Your task is to find and return the longest palindromic substring within the given string. A palindrome is a string that reads the same forwards and backwards.

Input :
A string s of length n. The length of the string satisfies 1≤n≤1000.
Input: "babad"

Output :
Return the longest substring of s that is a palindrome. If there are multiple solutions, return the first one that occurs.
Output: "bab"
 */

public class Problme13 {

    public static void main(String[] args) {
        String input = "babad";
        System.out.println("Longest Palindromic Substring: " + longestPalindrome(input));
    }

    // Function to find the longest palindromic substring
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0; // boundaries of longest palindrome
        for (int i = 0; i < s.length(); i++) {
            // Case 1: Odd length palindrome
            int len1 = expandFromCenter(s, i, i);
            // Case 2: Even length palindrome
            int len2 = expandFromCenter(s, i, i + 1);

            int len = Math.max(len1, len2);

            // Update longest palindrome indices
            if (len > (end - start)) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    // Expand from center and return length of palindrome
    private static int expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1; // length of palindrome
    }
}
