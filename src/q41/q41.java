package q41;
class Solution {
    public int firstMissingPositive(int[] nums) {
        int len= nums.length;
        //缺失的第一个正整数的范围一定是[1,len+1]
        //先将小于等于0的数替换成len+1
        for (int i = 0; i < len; i++) {
            if (nums[i] <= 0) nums[i] = len + 1;
        }
        //给出现过的数打上标记(将其替换为对应的负数)
        for (int i = 0; i < len; i++) {
            int abs = Math.abs(nums[i]);
            if (abs < len + 1) nums[abs - 1] = -Math.abs(nums[abs - 1]);
        }
        //寻找缺失的第一个正整数(寻找第一个为正数的元素的下标+1)
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) return i+1;
        }
        //如果全部都为负数，则缺失的第一个正整数为len+1
        return len + 1;
    }
}
public class q41 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.firstMissingPositive(new int[]{1,2,0}));
        System.out.println(solution.firstMissingPositive(new int[]{3,4,-1,1}));
        System.out.println(solution.firstMissingPositive(new int[]{7,8,9,11,12}));
    }
}
