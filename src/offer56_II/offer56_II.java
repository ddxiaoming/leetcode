package offer56_II;
class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int digit = 0; digit < 32; digit++) {
            int count = 0;
            // 统计第digit位中1出现的次数
            for (int num : nums) {
                count += num >> digit & 1;
            }
            // 将count与3取余，余数即为只出现一次的数，该位上的数字
            count = count % 3;
            //
            res = res | (count << digit);
        }
        return res;
    }
}
class Solution1 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int i = 0; i < 32; i++){
            int count = 0;
            for (int num : nums) {
                //先将数右移，并求出最后一位为 1 的个数
                if ((num >> i & 1) == 1) {
                    count++;
                }
            }
            //找到某一位取余为 1 的数，并左移，为了将这一位循环结束后移至原位
            if (count % 3 != 0) {
                res = res | 1 << i;
            }
        }
        return res;
    }
}
public class offer56_II {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.singleNumber(new int[]{3,4,3,3}));
        System.out.println(solution.singleNumber(new int[]{9,1,7,9,7,9,7}));
    }
}
