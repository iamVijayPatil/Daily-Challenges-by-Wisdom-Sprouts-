
import java.util.HashSet;

public class Problem3{
    public static void main(String[] args) {
        int[] arr = {1,3,4,2,3};
        System.out.println("Duplicate number is : " + duplicateNumber(arr));

        // -> Test Cases :
        // int[] arr2 = {1, 3, 4, 2, 2};
        // int[] arr3 = {3, 1, 3, 4, 2};
        // System.out.println("Duplicate number is : " + duplicateNumber(arr2));
        // System.out.println("Duplicate number is : " + duplicateNumber(arr3));
    }

    public static int duplicateNumber(int[] arr){
        //set implementation to store unique elements
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<arr.length;i++){
            if(set.contains(arr[i])){
                return arr[i];
            }
            set.add(arr[i]);
        }
        return -1;
    }
}