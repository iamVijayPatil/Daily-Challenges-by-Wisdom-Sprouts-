/*Day 19 of 30 🗓

Problem : Evaluate a Postfix Expression
Given a postfix expression (also known as Reverse Polish Notation), your task is to evaluate the expression and return the result. The expression can contain integers and the four basic arithmetic operators +, -, *, and /. Assume that the input is always valid and the division operator performs integer division, truncating towards zero.

Input :
- A string representing a postfix expression where operands and operators are separated by spaces.
- The string contains only integers (both positive and negative) and the operators +, -, *, and /.
- Input: "2 1 + 3 *"

Output :
An integer representing the result of evaluating the postfix expression.
Output: 9
 */
import java.util.Stack;

public class Problem19 {

    public static void main(String[] args) {
        String expression = "2 1 + 3 *";
        int result = evaluatePostfix(expression);
        System.out.println("Result: " + result); // Output: 9
    }
    
    public static int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>();
        String[] tokens = expression.split("\\s+");

        for (String token : tokens) {
            if (isOperator(token)) {
                int b = stack.pop();  // second operand
                int a = stack.pop();  // first operand
                stack.push(applyOperation(a, b, token));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-")
                || token.equals("*") || token.equals("/");
    }

    private static int applyOperation(int a, int b, String operator) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b; // integer division (truncates toward zero)
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}
