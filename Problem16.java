public class Problem16 {
    public static void main(String[] args) {
        long N = 4, M = 6;
        System.out.println(lcm(N, M)); // Output: 12
    }

    // Function to compute GCD using Euclidean algorithm
    public static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Function to compute LCM
    public static long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;  // To avoid overflow
    }
}
