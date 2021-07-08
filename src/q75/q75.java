package q75;

import util.PrintUtil;

class Solution {
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1;
        int i = 0;
        while (left <= right && i <= right) {
            if (nums[i] == 0) {
                swap(nums, i, left++);
            } else if (nums[i] == 2) {
                swap(nums, i, right--);
                //如果2换出来的是0或者2，那么i不变还要继续进行交换
                if (nums[i] == 0 || nums[i] == 2) i--;
            }
            i++;
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
public class q75 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums;

        nums = new int[]{2,0,2,1,1,0};
        solution.sortColors(nums);
        PrintUtil.printArray(nums);

        nums = new int[]{2,0,2,1,1,0,1,2,0,0,2,1,1};
        solution.sortColors(nums);
        PrintUtil.printArray(nums);

        nums = new int[]{2,0,1};
        solution.sortColors(nums);
        PrintUtil.printArray(nums);

        nums = new int[]{0};
        solution.sortColors(nums);
        PrintUtil.printArray(nums);

        nums = new int[]{1};
        solution.sortColors(nums);
        PrintUtil.printArray(nums);
    }
}
