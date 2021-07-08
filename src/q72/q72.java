package q72;
class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        char[] array1 = word1.toCharArray();
        char[] array2 = word2.toCharArray();
        int[][] dp = new int[len1 + 1][len2 + 1];

        //初始化dp数组
        for (int i = 0; i <= len1; i++) dp[i][0] = i;
        for (int i = 0; i <= len2; i++) dp[0][i] = i;

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (array1[i - 1] == array2[j - 1]) dp[i][j] = dp[i - 1][j - 1];//状态转移
                else dp[i][j] = min(dp[i - 1][j], dp[i][j - 1], dp[i -1][j -1]) + 1;//状态转移
            }
        }
        return dp[len1][len2];
    }
    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
public class q72 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minDistance("horse", "ros"));
        System.out.println(solution.minDistance("intention", "execution"));
    }
}
