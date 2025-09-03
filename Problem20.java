/* Day 20 of 30 🗓

Problem : Sort a Stack Using Recursion
Given a stack of integers, your task is to write a function that sorts the stack in ascending order. You are not allowed to use any additional data structure like arrays, lists, or another stack. The only operations you are allowed to perform are push, pop, and peek on the stack. The sorting must be performed using recursion only.

You need to recursively sort the stack, ensuring that after the sorting process, the stack remains sorted without using any additional data structures. You can only use the stack's own operations and recursion to solve this problem.

Input :
* A stack containing integers. The stack may have positive, negative, or zero values.
* Input: [3, 1, 4, 2]

Output :
The input stack should be sorted in ascending order (smallest elements on the top and largest at the bottom) after the sorting operation is performed.
Output: [1, 2, 3, 4]
 */
import java.util.Stack;

public class Problem20 {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);
        System.out.println("Original Stack: " + stack);
        sortStack(stack);
        System.out.println("Sorted Stack  : " + stack);
    }

    // Function to sort the stack using recursion
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            // Remove the top element
            int top = stack.pop();

            // Sort the remaining stack
            sortStack(stack);

            // Insert the element back in sorted order
            insertInSortedOrder(stack, top);
        }
    }

    // Helper function to insert element into sorted stack
    private static void insertInSortedOrder(Stack<Integer> stack, int element) {
        // Base case: either stack is empty or top element <= element
        if (stack.isEmpty() || stack.peek() <= element) {
            stack.push(element);
            return;
        }

        // Otherwise, pop the top and recurse
        int top = stack.pop();
        insertInSortedOrder(stack, element);

        // Push the top back after inserting
        stack.push(top);
    }
}
