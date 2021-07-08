package q33;
/*class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;
        if (target <= nums[len - 1]) {
            //证明target在右半部分
            for (int i = len - 1; i >=0; i--) {
                if (target == nums[i]) return i;
                if (target > nums[i]) return -1;//此时说明不存在了
            }
        } else {
            //证明target在左半部分
            for (int i = 0; i < len - 1; i++) {
                if (target == nums[i]) return i;
                if (target < nums[i]) return -1;
            }
        }
        return -1;
    }
}*/
class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (target == nums[i]) return i;
        }
        return -1;
    }
}
public class q33 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.search(new int[]{4,5,6,7,0,1,2}, 6));
    }
}
