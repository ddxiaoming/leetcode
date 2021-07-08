package offer10_II;
class Solution {
    private static final int MOD = 1000000007;
    public int numWays(int n) {
        if (n == 0) return 1;
        else if (n == 1 || n == 2) return n;
        int a = 1, b = 2, sum = a + b;
        for (int i = 3; i <= n; i++) {
            sum = (a % MOD + b % MOD) % MOD;
            a = b;
            b = sum;
        }
        return sum;
    }
}
public class offer10_II {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numWays(2));
        System.out.println(solution.numWays(7));
        System.out.println(solution.numWays(0));
    }
}
