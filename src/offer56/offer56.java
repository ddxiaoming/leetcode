package offer56;
class Solution {
    public int[] singleNumbers(int[] nums) {
        // x, y 为不相同的两个数字, xor 为 x 与 y 异或的结果, 即 xor = x ^ y
        int x = 0, y = 0, xor = 0;
        // 求出 xor 的结果
        for (int num : nums) xor = xor ^ num;
        // 按照div这个数字可以将数组划分为两个数组
        int div = 1;
        // 求出 div
        while ((div & xor) == 0) div = div << 1;
        // 一边进行数组划分，一边进行异或
        for (int num : nums) {
            if ((div & num) == 0) x = x ^ num;
            else y = y ^ num;
        }
        return new int[]{x, y};
    }
}
public class offer56 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] res = solution.singleNumbers(new int[]{1, 1, 2, 9, 2, 3, 3, 4});
        System.out.println(res[0] + " " + res[1]);
    }
}
