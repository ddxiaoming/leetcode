package q55;
class Solution {
    public boolean canJump(int[] nums) {
        int maxPos = 0;//最远可到达处
        for (int i = 0; i < nums.length; i++) {
            if (i > maxPos) return false;
            maxPos = Math.max(maxPos, i + nums[i]);
        }
        return true;
    }
}
public class q55 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canJump(new int[]{2,3,1,1,4}));
        System.out.println(solution.canJump(new int[]{3,2,1,0,4}));
    }
}
