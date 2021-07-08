package q45;
class Solution {
    public int jump(int[] nums) {
        int len = nums.length;
        //当前位置（局部最优的位置）
        int currentPos = 0;
        int step = 0;
        while (currentPos != len - 1) {
            //如果当前位置可以直接跳到终点
            if (nums[currentPos] + currentPos >= len - 1) {
                return ++step;
            }
            //如果当前位置不可以直接跳到终点
            int nextPos = currentPos + 1;
            for (int i = currentPos + 1; i <= nums[currentPos] + currentPos; i++) {
                if (nums[nextPos] + nextPos <= nums[i] + i) nextPos = i;
            }
            step++;
            currentPos = nextPos;
        }
        return step;
    }
}
public class q45 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.jump(new int[]{2,3,1,1,4}));
        System.out.println(solution.jump(new int[]{0}));
        System.out.println(solution.jump(new int[]{3,2,1}));
        System.out.println(solution.jump(new int[]{1,2,1,1,1}));
        System.out.println(solution.jump(new int[]{10,9,8,7,6,5,4,3,2,1,1,0}));
    }
}
