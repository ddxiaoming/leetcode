package q35;
class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
//        return nums[right] < target ? right + 1 : right;
        return right + 1;
    }
}
public class q35 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.searchInsert(new int[]{3,5,7,9,10,12}, 0));
    }
}
