/*Day 12 of 30 🗓

Problem : Valid Parentheses with Multiple Types
You are given a string s consisting of different types of parentheses: (), {}, and []. Your task is to determine whether the given string is valid.
A string is considered valid if:
1. Every opening bracket has a corresponding closing bracket of the same type.
2. The brackets are closed in the correct order. This means that a closing bracket must close the most recent unmatched opening bracket.

Input :
A string s consisting of characters (, ), {, }, [, and ].
Input: s = "[{()}]"

Output :
- Return true if the string is valid.
- Return false if the string is invalid.
Output: true
 */

import java.util.Stack;
public class Problem12 {

    public static void main(String[] args) {
        String s = "[{()}]";
        System.out.println(validParenthesis(s)); // true
    }

    public static boolean validParenthesis(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            // Push opening brackets
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                // If closing bracket but stack is empty → invalid
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();
                if ((ch == ')' && top != '(')
                        || (ch == '}' && top != '{')
                        || (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }
        // Valid if no unmatched opening brackets remain
        return stack.isEmpty();
    }
}
