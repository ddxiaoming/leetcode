package q80;

import util.PrintUtil;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int removeDuplicates(int[] nums) {
        //[0,slow]表示处理之后符合条件的区间
        //前两个元素一定符合条件，所以慢指针初始化为1
        int slow = 1, fast = 2;
        for (fast = 2; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow - 1]) {
                //先扩张当前区间，慢指针+1，然后对区间的边界值进行赋值
                nums[++slow] = nums[fast];
            }
        }
        return slow + 1;
    }
}
public class q80 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] num;
        num = new int[]{1, 1, 1, 2, 2, 3};
        System.out.println(solution.removeDuplicates(num));
        PrintUtil.printArray(num);
    }
}
