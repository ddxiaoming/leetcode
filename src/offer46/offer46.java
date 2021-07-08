package offer46;
class Solution {
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1];
            int n = Integer.parseInt(s.substring(i - 2, i));
            if (10 <= n && n <= 25) dp[i] += dp[i - 2];
        }
        return dp[len];
    }
}
public class offer46 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.translateNum(12258));
    }
}
