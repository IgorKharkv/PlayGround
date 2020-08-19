import java.util.ArrayList;
import java.util.HashMap;
import java.util.SortedMap;
import java.util.TreeMap;

public class Main {

    public static HashMap<Character, Integer> hmap = new HashMap();

    //check for number prime or not
    static boolean isPrime(int n) {
        //check if n is a multiple of 2
        if (n % 2 == 0) return false;
        //if not, then just check the odds
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

        public static void main(String args[])
    {
        int number = 10;
        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = 1 ; i < 10 ; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }

        System.out.println(primes);
    }
}
