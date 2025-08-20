/*
 Problem : Find All Subarrays with Zero Sum
You are given an integer array arr of size n. Your task is to find all the subarrays whose elements sum up to zero. A subarray is defined as a contiguous part of the array, and you must return the starting and ending indices of each subarray.

Input :
An integer array arr of size n where n represents the number of elements in the array.
Example : 
Input: [1, 2, -3, 3, -1, 2]

Output :
- Return a list of tuples, where each tuple contains two integers. The starting index (0-based) of the subarray. The ending index (0-based) of the subarray.
- The output should list all subarrays that sum to zero. If no such subarrays are found, return an empty list.
Example
Output: [(0, 2)]
 */

import java.util.*;

public class Problem6 {

    public static void main(String[] args) {
        int[] arr = {1, 2, -3, 3, -1, 2};
        int[] subarray = findOneZeroSumSubarray(arr);
        if (subarray.length > 0) {
            System.out.println("(" + subarray[0] + ", " + subarray[1] + ")");
        } else {
            System.out.println("No subarray found");
        }

    }

    public static int[] findOneZeroSumSubarray(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        map.put(0, -1); // handle subarray starting at 0

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            if (map.containsKey(prefixSum)) {
                return new int[]{map.get(prefixSum) + 1, i};
            }

            map.put(prefixSum, i);
        }
        return new int[]{}; // no subarray found
    }
}
