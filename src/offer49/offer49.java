package offer49;
class Solution {
    public int nthUglyNumber(int n) {
        // 第一个丑数是dp[0]，第n个丑数是dp[n - 1]
        int[] dp = new int[n];
        int a = 0, b = 0, c = 0;
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            int num2 = dp[a] * 2,  num3 = dp[b] * 3, num5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(num2, num3), num5);

            // 此时证明第i + 1个丑数是由第a个丑数 *2 得来的
            // 指针a移动一位，以产生下一个丑数
            if (num2 == dp[i]) a++;
            if (num3 == dp[i]) b++;
            if (num5 == dp[i]) c++;
        }
        return dp[n - 1];
    }
}
public class offer49 {
}
