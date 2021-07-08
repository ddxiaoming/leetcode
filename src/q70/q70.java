package q70;
class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n +1];
        if (1 <= n) dp[1] = 1;
        if (1 <= n) dp[2] = 2;
        for (int i = 1; i <= n; i ++) dp[i] = dp[i - 1] + dp[i - 2];
        return dp[n];
    }
}
public class q70 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.climbStairs(2));
        System.out.println(solution.climbStairs(3));
    }
}
