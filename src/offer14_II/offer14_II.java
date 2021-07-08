package offer14_II;

/**
 * 贪心
 */
class Solution {
    private static final int MOD = 1000000007;
    public int cuttingRope(int n) {
        // 当 n = 2时，结果 = 1
        // 当 n = 3时，结果 = 2
        if (n < 4) return n - 1;
        long res = 1;
        // 将绳子尽可能多的拆分成长度为 3 的小段
        while (n > 4) {
            res = (res * 3) % MOD;
            n = n -3;
        }
        // 最后剩余的结果可能是n = 1、2、3、4，此时不再拆分
        return (int) (res * n % MOD);
    }
}
public class offer14_II {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.cuttingRope(2));
        System.out.println(solution.cuttingRope(10));
        System.out.println(solution.cuttingRope(100));
        System.out.println(solution.cuttingRope(1000));
    }
}
