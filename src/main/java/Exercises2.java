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

    /*
    Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

    Symbol       Value
    I             1
    V             5
    X             10
    L             50
    C             100
    D             500
    M             1000

    For example, 2 is written as II in Roman numeral, just two ones added together.
    12 is written as XII, which is simply X + II.
    The number 27 is written as XXVII, which is XX + V + II.

    Roman numerals are usually written largest to smallest from left to right.
    However, the numeral for four is not IIII.
    Instead, the number four is written as IV.
    Because the one is before the five we subtract it making four.
    The same principle applies to the number nine, which is written as IX.
    There are six instances where subtraction is used:

    I can be placed before V (5) and X (10) to make 4 and 9.
    X can be placed before L (50) and C (100) to make 40 and 90.
    C can be placed before D (500) and M (1000) to make 400 and 900.

    Given a roman numeral, convert it to an integer.
    */

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

    /*
    Given an array nums of distinct integers, return all the possible permutations.
    You can return the answer in any order.
    */

    public List<List<Integer>> permute(int[] nums) {
        // TODO
        return null;
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
    }
}