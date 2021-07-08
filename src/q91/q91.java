package q91;

/**
 * 91.解码方法
 */
class Solution {
    public int numDecodings(String s) {
        char[] array = s.toCharArray();
        int len = array.length;
        //dp数组长度为array.length + 1，dp[i]表示[0, i-1]的子字符串的解码方法个数，这样做可以防止dp数组越界
        int[] dp = new int[len + 1];
        if (array[0] == '0') return 0;
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 1; i < len; i++) {
            int num = (array[i - 1] - '0') * 10 + (array[i] - '0');
            if (array[i] == '0') {
                if (array[i - 1] == '1' || array[i - 1] == '2') dp[i + 1] = dp[i - 1];
                else return 0;
            } else if (10 < num && num < 27) {
                dp[i + 1] = dp[i] + dp[i - 1];
            } else {
                dp[i + 1] = dp[i];
            }
        }
        return dp[len];
    }
}
public class q91 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numDecodings("12"));
        System.out.println(solution.numDecodings("226"));
        System.out.println(solution.numDecodings("0"));
        System.out.println(solution.numDecodings("06"));
        System.out.println(solution.numDecodings("063"));
        System.out.println(solution.numDecodings("603"));
        System.out.println(solution.numDecodings("10"));
    }
}
