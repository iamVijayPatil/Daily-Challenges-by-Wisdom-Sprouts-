/*Day 22 of 30 🗓

Problem : First Element to Repeat k Times
You are given an array of integers and an integer k. Your task is to find the first element in the array that appears exactly k times. If no such element exists, return -1.

Input :
* An integer array arr of size n, where 1≤n≤105
* An integer k, where 1≤k≤n
* Input: arr = [3, 1, 4, 4, 5, 2, 6, 1, 4], k = 2

Output :
Return the first element from the array that occurs exactly k times. If no element occurs exactly k times, return -1.
Output: 1

 */
import java.util.*;

public class Problem22 {

    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 4, 5, 2, 6, 1, 4};
        int k = 2;

        System.out.println(firstElementToRepeatKTimes(arr, k)); // Output: 1
    }

    public static int firstElementToRepeatKTimes(int[] arr, int k) {
        Map<Integer, Integer> freq = new HashMap<>();

        // Count frequency of each element
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Traverse array again to maintain order
        for (int num : arr) {
            if (freq.get(num) == k) {
                return num;
            }
        }
        return -1; // If no element found
    }
}
