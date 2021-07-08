package offer19;
class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        // dp[x][y]代表长度为x的字符串s与长度为y的模式串p能否匹配
        boolean[][] dp = new boolean[m + 1][n + 1];
        // dp[0][0]表示空串s与空串p能够进行匹配
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    // 默认不进行匹配，扔掉字母+星号的组合
                    dp[i][j] = dp[i][j - 2];
                    if (matches(s, p, i - 1, j - 2)) dp[i][j] = dp[i][j - 2] || dp[i - 1][j];
                } else {
                    if (matches(s, p, i - 1, j - 1)) dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }

    /**
     * 字符s[i]与字符p[j]能否匹配
     */
    private boolean matches(String s, String p, int i, int j) {
        // 越界
        if (i < 0 || i >= s.length() || j < 0 || j >= p.length()) return false;
        if (p.charAt(j) == '.') return true;
        return s.charAt(i) == p.charAt(j);
    }
}
public class offer19 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isMatch("aab", "c*a*b"));
    }
}
