package offer42;
class Solution {
    public int maxSubArray(int[] nums) {
        int len = nums.length, max = nums[0], pre = nums[0], cur = nums[0];
//        int[] dp = new int[len];
//        dp[0] = nums[0];
        for (int i = 1; i < len; i++) {
            cur = Math.max(pre + nums[i], nums[i]);
            pre = cur;
//            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, cur);
        }
        return max;
    }
}
public class offer42 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
