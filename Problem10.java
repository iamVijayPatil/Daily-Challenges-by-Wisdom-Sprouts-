/*
 Group Anagrams
You are given an array of strings strs[]. Your task is to group all the strings that are anagrams of each other. An anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
The goal is to return the grouped anagrams as a list of lists, where each sublist contains words that are anagrams of each other.

Input :
An array of strings strs[] consisting of lowercase English letters.
Input: strs[] = ["eat", "tea", "tan", "ate", "nat", "bat"]

Output :
A list of lists, where each sublist contains strings that are anagrams of each other. The order of the output groups does not matter.
Output: [["eat", "tea", "ate"], ["tan", "nat"], ["bat"

 */
import java.util.*;

public class Problem10 {

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        // String[] input1 = {"eat"};

        List<List<String>> result = groupAnagrams(strs);
        System.out.println(result);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        for (String word : strs) {
            // Step 1: Create frequency count
            int[] count = new int[26];
            for (char c : word.toCharArray()) {
                count[c - 'a']++;
            }

            // Step 2: Build a unique key from count
            StringBuilder keyBuilder = new StringBuilder();
            for (int num : count) {
                keyBuilder.append(num).append('#'); // separator to avoid ambiguity
            }
            String key = keyBuilder.toString();

            // Step 3: Add word to hashmap
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }

        // Step 4: Collect groups
        return new ArrayList<>(map.values());
    }
}
