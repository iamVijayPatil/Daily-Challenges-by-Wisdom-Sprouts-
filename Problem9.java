/*You are given an array of strings strs[], consisting of lowercase letters. Your task is to find the longest common prefix shared among all the strings. If there is no common prefix, return an empty string "".
A common prefix is a substring that appears at the beginning of all the strings in the array. The task is to identify the longest such prefix that all strings share.

Input:
An array of strings strs[] where each string consists of lowercase English letters.

Output:
A string representing the longest common prefix. If no common prefix exists, return an empty string ""
 */

public class Problem9 {

    public static void main(String[] args) {
        String[] str = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(str));

        // String[] str2 = {"flower"};
        // String[] str3 = {};
        // System.out.println(longestCommonPrefix(str2));
        // System.out.println(longestCommonPrefix(str3) + "Empty String");
    }

    public static String longestCommonPrefix(String[] str) {

        // edge Cases Handling
        if (str.length == 0) {
            return "";
        } else if (str.length == 1) {
            return str[0];
        }
        // 1st string character check with each string in str array
        for (int i = 0; i < str[0].length(); i++) {
            char character = str[0].charAt(i);
            for (int j = 1; j < str.length; j++) {
                if (i + 1 >= str[j].length() || str[j].charAt(i) != character){
                    return str[0].substring(0,i);
                }
            }
        }
    return "";
    }
}
