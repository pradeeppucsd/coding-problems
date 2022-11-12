import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Given an array of integers nums and an integer target, return indices of the two numbers such that
they add up to target.
Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]

* */
public class TwoSum {
    /**
    Brute force approach
    Time complexity: O(n^2)
    Space complexity: O(1)
    */
    public int[] twoSumApproach1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * Using extra memory:
     * Time complexity:  O(n)
     * Space complexity: O(n)
     * */
    private int[] twoSumApproach2(int[] nums, int target) {
        Map<Integer, Integer> numIndexMap = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            numIndexMap.put(nums[i], i);
        }
        for (int i=0;i<nums.length;i++) {
            int difference = target - nums[i];
            if(numIndexMap.containsKey(difference)) {
                return new int[] {i, numIndexMap.get(difference)};
            }
        }
        return null;
    }

    /**
     * Using extra memory but avoid one for loop
     * Time complexity:  O(n)
     * Space complexity: O(n)
     * */
    private int[] twoSumApproach3(int[] nums, int target) {
        Map<Integer, Integer> numIndexMap = new HashMap<>();
        for (int i=0;i<nums.length;i++) {
            int difference = target - nums[i];
            if(numIndexMap.containsKey(difference)) {
                return new int[] {numIndexMap.get(difference), i};
            }
            numIndexMap.put(nums[i],i );
        }
        return null;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        // Approach1
        int[] resultApproach1 = twoSum.twoSumApproach1(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(resultApproach1));

        // Approach2
        int[] resultApproach2 = twoSum.twoSumApproach2(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(resultApproach2));

        // Approach3
        int[] resultApproach3 = twoSum.twoSumApproach3(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(resultApproach3));


    }
}