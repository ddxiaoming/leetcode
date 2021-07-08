package offer16;
class Solution {
    public double myPow(double x, int n) {
        if (n < 0) return 1.0 / pow(x, -n);
        return pow(x, n);
    }
    private double pow(double x, long n) {
        double res = 1;
        while (n != 0) {
            if ((n & 1) == 1) {
                res *= x;
            }
            // n无符号右移
            n >>>= 1;
            // x进行平方
            x *= x;
        }
        return res;
    }
}
public class offer16 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.myPow(2.00000, 10));
        System.out.println(solution.myPow(2.10000, 3));
        System.out.println(solution.myPow(2.00000, -2));
        System.out.println(solution.myPow(1.00000, (int)Math.pow(2.0, 31.0)));
    }
}
