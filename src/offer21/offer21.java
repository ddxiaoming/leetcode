package offer21;

import util.PrintUtil;

/**
 * 快慢指针
 */
class Solution1 {
    public int[] exchange(int[] nums) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] % 2 == 1) swap(nums, slow++, fast);
        }
        return nums;
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

/**
 * 首尾双指针
 */
class Solution {
    public int[] exchange(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] % 2 == 1) {
                // left指向奇数
                left++;
            } else if (nums[right] % 2 == 0) {
                // right指向偶数
                right--;
            } else {
                // left指向偶数且right指向奇数
                swap(nums, left++, right--);
            }
        }
        return nums;
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
public class offer21 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        PrintUtil.printArray(solution.exchange(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
    }
}
