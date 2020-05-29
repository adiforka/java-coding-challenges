package java_coding_challenges;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class JCC2_TwoSum {
    public static void main(String[] args) {

        //return two indices of elements in the array that sum up to the given target value (use a number only
        //once to find the first solution)
        int[] result = getTwoSum(new int[]{2, 3, 7, 4, 8}, 7);
        System.out.println(Arrays.toString(result));

        result = getTwoSum(new int[]{2, 3, 7, 4, 8}, 6);
        System.out.println(Arrays.toString(result));

        result = getTwoSum(new int[]{2, 3, 7, 4, 8}, -4);
        System.out.println(Arrays.toString(result));

    }
    public static int[] getTwoSum(int[] numbers, int target) {

        Map<Integer, Integer> visitedNumbers = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int delta = target - numbers[i];
            if (visitedNumbers.containsKey(delta)) {
                return new int[]{i, visitedNumbers.get(delta)};
            }
            visitedNumbers.put(numbers[i], i);
        }

        return new int[]{-1, -1};
    }
}
