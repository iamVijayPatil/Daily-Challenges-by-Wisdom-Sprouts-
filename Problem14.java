/*
 Problem : Count Substrings with Exactly K Distinct Characters
You are given a string s of lowercase English alphabets and an integer k. Your task is to count all possible substrings of s that contain exactly k distinct characters.

Input :
* A string s consisting of lowercase English letters.
* An integer k, where 1 ≤ 𝑘 ≤ 26
* The length of the string satisfies 1 ≤ 𝑛 ≤ 104
* Example - s = "pqpqs", k = 2

Output :
Return an integer that represents the number of substrings of s that contain exactly k distinct characters.
Output: 7

 */
import java.util.*;
public class Problem14 {

    public static void main(String[] args) {
        String s = "pqpqs";
        int k = 2;
        System.out.println(countExactlyKDistinct(s, k)); // Output: 7
    }

    // Main function to count substrings with exactly k distinct characters
    public static int countExactlyKDistinct(String s, int k) {
        return countAtMostKDistinct(s, k) - countAtMostKDistinct(s, k - 1);
    }

    // Helper function: counts substrings with at most k distinct characters
    private static int countAtMostKDistinct(String s, int k) {
        if (k == 0) {
            return 0;
        }

        int n = s.length();
        int left = 0, result = 0;
        Map<Character, Integer> freq = new HashMap<>();

        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);
            freq.put(c, freq.getOrDefault(c, 0) + 1);

            // Shrink window until we have at most k distinct characters
            while (freq.size() > k) {
                char leftChar = s.charAt(left);
                freq.put(leftChar, freq.get(leftChar) - 1);
                if (freq.get(leftChar) == 0) {
                    freq.remove(leftChar);
                }
                left++;
            }

            // Every substring ending at 'right' with valid window contributes
            result += (right - left + 1);
        }
        return result;
    }
}
