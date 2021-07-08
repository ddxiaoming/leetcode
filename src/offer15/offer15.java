package offer15;
class Solution {
    public int hammingWeight(int n) {
        int ans = 0;
        while (n != 0) {
            //不断与1进行与操作
            ans += n & 1;
            //无符号右移1位
            n = n >>> 1;
        }
        return ans;
    }
}
public class offer15 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        //java中要输入二进制直接0bxxxxxx即可
        System.out.println(solution.hammingWeight(0b00000000000000000000000000001011));
        System.out.println(solution.hammingWeight(0b00000000000000000000000010000000));
        System.out.println(solution.hammingWeight(0b11111111111111111111111111111101));
    }
}
