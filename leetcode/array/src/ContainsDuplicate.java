import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * Given an integer array nums, return true if any value appears at least twice in the array,
 * and return false if every element is distinct.
 *
 * Example 1:
 * Input: nums = [1,2,3,1]
 * Output: true
 *
 * Example 2:
 * Input: nums = [1,2,3,4]
 * Output: false
 *
 * Example 3:
 * Input: nums = [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 *
 * */
public class ContainsDuplicate {

    public static void main(String[] args) {
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();

        // Approach1
        boolean result1 = containsDuplicate.isContainsDuplicateApproach1(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2});
        System.out.println("Approach1 Result: "+ result1);

        // Approach2
        boolean result2 = containsDuplicate.isContainsDuplicateApproach2(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2});
        System.out.println("Approach2 Result: "+ result2);

        // Approach3
        boolean result3 = containsDuplicate.isContainsDuplicateApproach3(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2});
        System.out.println("Approach3 Result: "+ result3);
    }

    /**
     * Using Sort method
     * Time complexity:  O(n)
     * Space complexity: O(1)
     *
     * @param nums
     * @return
     */
    private boolean isContainsDuplicateApproach3(int[] nums) {
        Arrays.sort(nums);
        for (int i=1; i< nums.length;i++) {
            if(nums[i] == nums[i-1]) {
                return true;
            }
        }
        return false;
    }

    /**
     * Using extra memory
     * Time complexity:  O(n)
     * Space complexity: O(n)
     *
     * @param nums
     * @return
     */
    private boolean isContainsDuplicateApproach2(int[] nums) {
        List<Integer> countArray = new ArrayList<>();
        for (int i=0; i< nums.length;i++) {
            if(countArray.contains(nums[i])) {
                return true;
            }
            countArray.add(nums[i]);
        }
        return false;
    }

    /**
     * Bruteforce approach
     * Time complexity:  O(n^2)
     * Space complexity: O(1)
     *
     * @param elements
     * @return
     */
    private boolean isContainsDuplicateApproach1(int[] elements) {
        for (int i = 0; i < elements.length; i++) {
            for (int j = i + 1; j < elements.length; j++) {
                if (elements[i] == elements[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
