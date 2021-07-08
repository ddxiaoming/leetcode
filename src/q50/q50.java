package q50;

/**
 * 方法2 快速幂+迭代
 */
class Solution {
    public double myPow(double x, int n) {
        if (n < 0) return 1 / pow(x, -((long)n));
        return pow(x, n);
    }
    //pow函数中的n使用long类型，防止Integer.MIN_VALUE在取绝对值转为正数时溢出
    private double pow(double x, long n) {
        double res = 1.0;
        while (n > 0) {
            //如果n的二进制形式的最低位是1(n为奇数)
            if (n % 2 == 1) res *= x;
            //n右移一位，同时将x平方
            n = n >> 1;
            x *= x;
        }
        return res;
    }
}
public class q50 {
    public static void main(String[] args) {
        System.out.println(new Solution().myPow(2.00000, -2147483648));
        System.out.println(new Solution().myPow(2.00000, 10));
        System.out.println(new Solution().myPow(2.10000, 3));
        System.out.println(new Solution().myPow(2.00000, -2));
        System.out.println(new Solution().myPow(2, 222));
        System.out.println(new Solution().myPow(0, -2));
    }
}
