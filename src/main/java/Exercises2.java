import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exercises2 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }

        return null;
    }


    public int romanToInt(String s) {
        Map<Character, Integer> romanToInteger = new HashMap<>();
        romanToInteger.put('I', 1);
        romanToInteger.put('V', 5);
        romanToInteger.put('X', 10);
        romanToInteger.put('L', 50);
        romanToInteger.put('C', 100);
        romanToInteger.put('D', 500);
        romanToInteger.put('M', 1000);

        int result = 0;
        int prevValue = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int curValue = romanToInteger.get(s.charAt(i));
            if (curValue < prevValue) {
                result -= curValue;
            } else {
                result += curValue;
            }
            prevValue = curValue;
        }

        return result;
    }


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int num : nums) {
            if (!current.contains(num)) {
                current.add(num);
                backtrack(result, current, nums);
                current.remove(current.size() - 1);
            }
        }
    }


    public static void main(String[] args) {
        Exercises2 exercises = new Exercises2();

        // Test twoSum
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = exercises.twoSum(nums, target);
        System.out.println("Two Sum: [" + result[0] + ", " + result[1] + "]");
        // Test romanToInt
        String romanNumeral = "XXVII";
        int intValue = exercises.romanToInt(romanNumeral);
        System.out.println("Roman to Integer: " + intValue);
        // Test permute
        int[] numsForPermute = {1, 2, 3};
        List<List<Integer>> permutations = exercises.permute(numsForPermute);
        System.out.println("Permutations: " + permutations);

    }
}