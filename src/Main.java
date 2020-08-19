import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static HashMap<Character, Integer> hmap = new HashMap();

    public static void main(String args[])
    {
        int[] nums = {1,2,3,4,5,6,7,8,9,10,11,12,13,14};
        List<List<Integer>> output = new ArrayList();
        output.add(new ArrayList<Integer>());

        for (int num : nums) {
            List<List<Integer>> newSubsets = new ArrayList();
            for (List<Integer> curr : output) {
                newSubsets.add(new ArrayList<Integer>(curr){{add(num);}});
            }
            for (List<Integer> curr : newSubsets) {
                output.add(curr);
            }
        }
        System.out.println(output);
    }
}
