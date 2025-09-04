/*Day 21 of 30 🗓 Problem : Reverse a Stack Using Recursion You are given a stack of integers, and your task is to write a function that reverses the stack using recursion. You are not allowed to use any additional data structure (like arrays, lists, or another stack). The only operations you are allowed to perform are push, pop, and peek on the stack. The reversal must be done using recursion only. Input : * A stack of integers. The stack may contain positive, negative, or zero values. * Input: [1, 2, 3, 4] Output : The stack should be reversed, meaning the element that was at the bottom of the original stack should become the topmost element after the reversal. Output: [4, 3, 2, 1]
 */
import java.util.Stack;

public class Problem21 {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println("Original Stack: " + stack);
        reverseStack(stack);
        System.out.println("Reversed Stack: " + stack);
    }

    // Function to insert element at the bottom of the stack
    private static void insertAtBottom(Stack<Integer> stack, int value) {
        if (stack.isEmpty()) {
            stack.push(value);
            return;
        }
        int top = stack.pop();
        insertAtBottom(stack, value);
        stack.push(top);
    }

    // Function to reverse the stack recursively
    public static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int top = stack.pop();
        reverseStack(stack);
        insertAtBottom(stack, top);
    }
}
