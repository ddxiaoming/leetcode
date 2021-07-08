package q34;
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int index = binarySerach(nums, target);
        if (index == -1) return new int[]{-1, -1};
        int start = index, end = index;
        while (start > -1 && nums[start] == target) start--;
        while (end < nums.length && nums[end] == target) end++;
        return new int[]{start + 1, end - 1};
    }
    private int binarySerach(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}
public class q34 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.searchRange(new int[]{},5));
    }
}
