
import java.util.Arrays;
import java.util.Stack;

/*Problem :- You are given an integer array arr of size n. An element is considered a leader if it is greater than all the elements to its right. Your task is to find all such leader elements in the array.

Input:
An integer array arr of size n.
Example : 
arr = [16, 17, 4, 3, 5, 2]

Output:
Return an array containing all the leader elements in the order in which they appear in the original array.
Example:
Leaders: [17, 5, 2]
 */
public class Problem5 {

    public static void main(String[] args) {
        int[] arr = {16, 17, 4, 3, 5, 2};
        System.out.println(Arrays.toString(findRightLeader(arr)));
    }

    public static int[] findRightLeader(int[] arr) {
        int n = arr.length;
        int rightMost = arr[n - 1];
        
        Stack<Integer> stack = new Stack<>();
        stack.push(rightMost);

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > rightMost) {
                rightMost = arr[i];
                stack.push(rightMost);
            }
        }

        int[] result = new int[stack.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = stack.pop();
        }
        return result;
    }
}
