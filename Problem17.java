
import java.util.*;

public class Problem17 {

    public static void main(String[] args) {
        int N = 18;
        System.out.println("Prime factors of " + N + " are: " + primeFactorization(N));
    }

    public static List<Integer> primeFactorization(int n) {
        List<Integer> factors = new ArrayList<>();

        // Divide by 2 until n is odd
        while (n % 2 == 0) {
            factors.add(2);
            n /= 2;
        }
        // Divide by odd numbers up to sqrt(n)
        for (int i = 3; i * i <= n; i += 2) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        // If n is still > 2, then n is prime
        if (n > 2) {
            factors.add(n);
        }
        return factors;
    }
}
