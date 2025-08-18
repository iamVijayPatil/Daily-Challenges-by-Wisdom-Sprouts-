/*
Problem : Merge Two Sorted Arrays
You are given two sorted arrays arr1 of size m and arr2 of size n. Your task is to merge these two arrays into a single sorted array without using any extra space (i.e., in-place merging). The elements in arr1 should be merged first, followed by the elements of arr2, resulting in both arrays being sorted after the merge.

Input :
Two sorted integer arrays arr1 of size m and arr2 of size n.
Example : 
arr1 = [1, 3, 5, 7]
arr2 = [2, 4, 6, 8]

Output :
Both arr1 and arr2 should be sorted after the merge. Since you cannot use extra space, the final result will be reflected in arr1 and arr2.
Example:
arr1 = [1, 2, 3, 4]
arr2 = [5, 6, 7, 8]
 */

import java.util.Arrays;

public class Problem4 {

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7, 9, 11};
        int[] arr2 = {0, 2, 4, 6, 8,10};
        mergeArray(arr1, arr2);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }

    public static void mergeArray(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int len = n + m;
        int gap = (len + 1) / 2;

        while (gap > 0) {
            int left = 0, right = left + gap;

            while (right < len) {
                if (left < n && right < n) {
                    // both in arr1 
                    swapIfGreater(arr1, arr1, left, right);
                } else if (left < n && right >= n) {
                    // arr1 & arr2
                    swapIfGreater(arr1, arr2, left, right - n);
                } else {
                    // both in arr2
                    swapIfGreater(arr2, arr2, left - n, right - n);
                }
                left++;
                right++;
            }
            if (gap == 1) break;
            gap = (gap + 1) / 2;
        }
    }

    private static void swapIfGreater(int[] arr1, int[] arr2, int i, int j) {
        if (arr1[i] > arr2[j]) {
            int temp = arr1[i];
            arr1[i] = arr2[j];
            arr2[j] = temp;
        }
    }
}
