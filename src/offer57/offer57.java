package offer57;

import util.PrintUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * HashMap法
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int num : nums) {
            int key = target - num;
            if (map.containsKey(key)) return new int[]{key, num};
            map.put(num, true);
        }
        return new int[]{};
    }
}

/**
 * master 分支
 * 碰撞双指针
 */
class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < target) left++;
            else if (sum > target) right--;
            else return new int[]{nums[left], nums[right]};
        }
        return new int[]{};
    }
}
public class offer57 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        PrintUtil.printArray(solution.twoSum(new int[]{10, 26, 30, 31, 47, 60}, 40));
    }
}
