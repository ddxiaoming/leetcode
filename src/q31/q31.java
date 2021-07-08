package q31;
class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int left, right;
        //找到左边的较小数
        for (left = len - 2; left >= 0; left--) {
            if (nums[left] < nums[left + 1]) break;
        }
        //如果left=-1，证明此数组为完全降序，直接将其反转
        if (left == -1) {
            reverse(nums, 0, len - 1);
            return;
        }
        //找到右边的较大数
        for (right = len - 1; right > left; right--) {
            if (nums[left] < nums[right]) break;
        }

        //交换两个数
        swap(nums, left, right);
        //交换完成后对left+1之后的数进行重新升序排列，因为left+1到len-1必定为降序，因此直接用双指针进行翻转即可
        reverse(nums, left + 1, len - 1);
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private void reverse(int[] nums, int start, int end) {
        while (start < end) swap(nums, start++, end--);
    }
}
public class q31 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.nextPermutation(new int[] {3,2,1});
    }
}
