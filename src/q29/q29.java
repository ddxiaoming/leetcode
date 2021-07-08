package q29;
class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == 0) return 0;
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        long dividendL = Math.abs((long)dividend), divisorL = Math.abs((long)divisor);
        if (dividendL < divisorL) return 0;
        boolean isSame = (dividend ^ divisor) >= 0;//JAVA中只有异或，没有同或
        int res = 0;
        for (int i = 31; i >= 0; i--) {
            long temp = dividendL >> i;
            if (temp >= divisorL) {
                res += 1 << i;
                dividendL -= (divisorL << i);
            }
        }
        return isSame ? res : -res;
    }
}
public class q29 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.divide(1, 3));
    }
}
