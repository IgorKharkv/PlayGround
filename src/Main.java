import java.util.HashMap;
import java.util.SortedMap;
import java.util.TreeMap;

public class Main {

    public static HashMap<Character, Integer> hmap = new HashMap();

    public static void main(String args[])
    {
        String s = "leetcode";
        for (int i = 0 ; i < s.toCharArray().length ; i++) {
            hmap.put(s.charAt(i), hmap.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0 ; i < s.toCharArray().length ; i++) {
            if (hmap.get(s.charAt(i)) == 0) {
                System.out.println(i);
                break;
            }
        }

        System.out.println(-1);
    }
}
