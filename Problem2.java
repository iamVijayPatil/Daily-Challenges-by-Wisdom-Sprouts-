/*Problem : Find the Missing Number
You are given an array arr containing n-1 distinct integers. The array consists of integers taken from the range 1 to n, meaning one integer is missing from this sequence. Your task is to find the missing integer.
 */

public class Problem2{
    public static void main(String[] args) {
        int[] arr = {1,2,4,5};
        // int[] arr2 = {2,3,4,5}; -> Test Case 2
        System.out.println("Missing number is : " + missingNumber(arr));
        // System.out.println(missingNumber(arr2)); -> Result of test case 2

    }

    public static int missingNumber(int[] arr){
        int n = arr.length + 1;
        int totalSum = n * (n + 1) / 2;
        int sum = 0;
        for(int a : arr){
            sum += a;            
        }
        return totalSum - sum;
    }
}
   
