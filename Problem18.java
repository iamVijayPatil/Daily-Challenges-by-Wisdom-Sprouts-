/*Day 18 of 30 🗓

Problem : Count the Number of Divisors of a Number
Given a positive integer N, your task is to find the total number of divisors (factors) of N. A divisor of N is any integer that divides N without leaving a remainder.
A divisor of a number is any integer that divides the number evenly (i.e., without a remainder). For example, for N = 12, its divisors are 1, 2, 3, 4, 6, 12, so the total number of divisors is 6.

Input :
A single integer N, where 1≤N≤109
N = 12

Output :
An integer representing the total number of divisors of N.
Output: 6

 */
public class Problem18 {

    public static void main(String[] args) {
    
        System.out.println(countDivisors(12));
    }
    public static int countDivisors(int N) {
        int count = 0;
        for (int i = 1; i * i <= N; i++) {
            if (N % i == 0) {
                if (i == N / i) {
                    // Perfect square divisor
                    count += 1;
                } else {
                    count += 2; // i and N/i
                }
            }
        }
        return count;
    }
}
