package q81;
class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return true;
            if (nums[mid] == nums[left]) {
                //不确定左边有序还是右边有序，直接扔掉左边界
                //因为是利用nums[left]和nums[mid]进行比较，判断哪半部分有序，因此是left++
                //如果是利用nums[right]和nums[mid]进行比较，则要换成right--
                left++;
                continue;
            }
            if (nums[mid] > nums[left]) {
                //左半部分有序

                if (nums[left] <= target && target < nums[mid]) {
                    //target在左半部分，而左半部分有序，则直接变成二分查找
                    right = mid - 1;
                } else {
                    //target在右半部分，右半部分部分有序，因此将左边界向右移动，尽量将部分有序变成完全有序
                    left = mid + 1;
                }
            } else {
                //右半部分有序

                if (nums[mid] < target && target <= nums[right]) {
                    //target在右半部分，而右半部分有序，则直接变成二分查找
                    left = mid + 1;
                } else {
                    //target在左半部分，左半部分部分有序，因此将右边界向左移动，尽量将部分有序变成完全有序
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}

public class q81 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums;
        nums = new int[]{2,5,6,0,0,1,2};
        System.out.println(solution.search(nums, 2));
        System.out.println(solution.search(nums, 5));
        System.out.println(solution.search(nums, 6));
        System.out.println(solution.search(nums, 0));
        System.out.println(solution.search(nums, 1));

        nums = new int[]{3, 1, 1};
        System.out.println(solution.search(nums, 3));
    }
}
