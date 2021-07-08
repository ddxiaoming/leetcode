class Solution {
    public int search(int[] nums, int target) {
        return halfSearch(nums, target) - halfSearch(nums, target - 1);
    }

    /**
     * 二分查找，找到target的右边界
     */
    private int halfSearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] <= target) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }
}
public class offer53_I {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Integer.MIN_VALUE);
        System.out.println(solution.search(new int[]{5, 7, 7, 8, 8, 10}, -2147483648));
        System.out.println(solution.search(new int[]{5, 7, 7, 8, 8, 10}, 6));
        System.out.println(solution.search(new int[]{5, 7, 7, 8, 8, 10}, 5));
    }
}
