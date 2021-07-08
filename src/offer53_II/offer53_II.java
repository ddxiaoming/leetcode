package offer53_II;
class Solution {
    public int missingNumber(int[] nums) {
        int left = 0, right = nums.length -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == mid) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }
}
public class offer53_II {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.missingNumber(new int[]{0,1,3}));
        System.out.println(solution.missingNumber(new int[]{0,1,2,3,4,5,6,7,9}));
    }
}
