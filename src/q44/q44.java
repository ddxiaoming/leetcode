package q44;
class Solution {
    public boolean isMatch(String s, String p) {
        char[] schar = s.toCharArray();
        char[] pchar = p.toCharArray();
        int sLen = schar.length, pLen = pchar.length;
        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        dp[0][0] = true;
        for (int i = 1; i <= pLen; i++) {
            if (pchar[i - 1] == '*') dp[0][i] = true;
            else break;
        }

        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                if (schar[i - 1] == pchar[j - 1] || pchar[j - 1] == '?') dp[i][j] = dp[i - 1][j - 1];
                else if (pchar[j - 1] == '*') dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
            }
        }

        return dp[sLen][pLen];
    }
}
public class q44 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isMatch("aa", "a"));
        System.out.println(solution.isMatch("aa", "*"));
        System.out.println(solution.isMatch("cb", "?a"));
        System.out.println(solution.isMatch("adceb", "*a*b"));
        System.out.println(solution.isMatch("acdcb", "a*c?b"));
    }
}
