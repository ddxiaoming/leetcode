package q189;
/*class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        //移动次数k=k%len
        k = k % len;
        reverse(0,nums.length-1,nums);
        reverse(0,k-1,nums);
        reverse(k,nums.length-1,nums);
    }
    private void reverse(int start, int end, int[] nums) {
        while (start < end) {
            int temp = nums[end];
            nums[end--] = nums[start];
            nums[start++] = temp;
        }
    }
}*/
class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        //移动次数k=k%len
        k = k % len;
        reverse(0,nums.length-1,nums);
        reverse(0,k-1,nums);
        reverse(k,nums.length-1,nums);
    }
    private void reverse(int start, int end, int[] nums) {
        while (start < end) {
            int temp = nums[end];
            nums[end--] = nums[start];
            nums[start++] = temp;
        }
    }
}
public class q189 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.rotate(new int[]{1,2,3,4,5,6,7}, 3);
    }
}
