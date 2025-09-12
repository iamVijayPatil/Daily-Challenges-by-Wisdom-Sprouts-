/* Day 29 of 30 🗓

Problem : Fibonacci Sequence using Dynamic Programming
You are given an integer n. Your task is to calculate the n-th Fibonacci number using Dynamic Programming.

Input :
* A single integer n (0 ≤ n ≤ 1000)
* Input : 5

Output :
Return the n-th Fibonacci number.
Output: 5
 */
import java.math.BigInteger;
import java.util.Scanner;

public class Problem29 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number : ");
        int n = sc.nextInt();
        

        System.out.println(fibonacci(n));
    }

    // Optimal Fibonacci using DP + Space Optimization
    static BigInteger fibonacci(int n) {
        if (n == 0) {
            return BigInteger.ZERO;
        }
        if (n == 1) {
            return BigInteger.ONE;
        }

        BigInteger prev1 = BigInteger.ONE;  // fib(1)
        BigInteger prev2 = BigInteger.ZERO; // fib(0)
        BigInteger curr = BigInteger.ZERO;

        for (int i = 2; i <= n; i++) {
            curr = prev1.add(prev2);
            prev2 = prev1;
            prev1 = curr;
        }
        return curr;
    }
}
