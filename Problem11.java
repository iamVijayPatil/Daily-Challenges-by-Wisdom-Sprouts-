/*Problem : Permutations of a String
You are given a string s. Your task is to generate and return all possible permutations of the characters in the string. A permutation is a rearrangement of the characters in the string, and each character must appear exactly once in every permutation. If there are duplicate characters in the string, the resulting permutations should also be unique (i.e., no repeated permutations).

Input :
A string s consisting of lowercase English letters. The length of the string n satisfies 1≤𝑛≤9.
Input: "abc"

Output :
An array of strings containing all unique permutations of the input string. The order of permutations in the output does not matter.
Output: ["abc", "acb", "bac", "bca", "cab", "cba"]
 */
import java.util.*;

public class Problem11 {
    public static void main(String[] args) {
        String input = "abc";
        String[] result = findWords(input);
        System.out.println(Arrays.toString(result));
    }

    public static String[] findWords(String str) {
        List<String> result = new ArrayList<>();
        char[] chars = str.toCharArray();
        Arrays.sort(chars); // sort to handle duplicates
        boolean[] used = new boolean[chars.length];
        backtrack(chars, used, new StringBuilder(), result);

        return result.toArray(new String[0]);
    }

    private static void backtrack(char[] chars, boolean[] used, StringBuilder path, List<String> result) {
        if (path.length() == chars.length) {
            result.add(path.toString());
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            // Skip already used
            if (used[i]) continue;
            // Skip duplicates
            if (i > 0 && chars[i] == chars[i - 1] && !used[i - 1]) continue;

            // Choose
            used[i] = true;
            path.append(chars[i]);

            // Explore
            backtrack(chars, used, path, result);

            // Undo (Backtrack)
            path.deleteCharAt(path.length() - 1);
            used[i] = false;
        }
    }
}
