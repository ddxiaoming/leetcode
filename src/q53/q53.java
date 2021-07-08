package q53;

import javax.sound.midi.Soundbank;

/**
 * 暴力法
 * -2,1,-3,4,-1,2,1,-5,4
 */
class Solution {
    public int maxSubArray(int[] nums) {
        int pre = nums[0], res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            res = Math.max(pre, res);
            /**
             * pre = Math.max(pre + nums[i], nums[i]);
             * res = Math.max(pre, res);
             * 这两句话相当于：
             * int now = Math.max(pre + nums[i], nums[i]);
             * res = Math.max(now, res);
             * pre = now;
             *
             * now相当于是个临时变量，最终now又赋值给了pre，那么一开始
             * pre = Math.max(pre + nums[i], nums[i]);这句话中，pre作为这次循环的now，作为下次循环的pre
             */
        }
        return res;
    }
}

/**
 * 动态规划法
 */
class Solution1 {
    public int maxSubArray(int[] nums) {
        int pre = 0, max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            //以当前第 i 个数结尾的「连续子数组的最大和」
            int now = Math.max(pre + nums[i], nums[i]);
            max = Math.max(now, max);
            //以第 i - 1 个数结尾的「连续子数组的最大和」
            pre = now;
        }
        return max;
    }
}
public class q53 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

}
