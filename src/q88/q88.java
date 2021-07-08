package q88;

import util.PrintUtil;

/**
 * 88.合并两个有序数组
 *
 */

/**
 * 方法1.从前往后，需要额外空间
 */
class Solution1 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] tmp = new int[m];
        int point1 = 0, point2 = 0;
        System.arraycopy(nums1, 0, tmp, 0, m);
        for (int i = 0; i < nums1.length; i++) {
            if (point1 == tmp.length) {//tmp到头了，用nums2来对nums1赋值
                nums1[i] = nums2[point2++];
            } else if (point2 == nums2.length) {//nums2到头了，用tmp来对nums1赋值
                nums1[i] = tmp[point1++];
            } else if (tmp[point1] < nums2[point2]) {//tmp < nums2，用tmp来对nums1赋值
                nums1[i] = tmp[point1++];
            } else {//nums2 < tmp，用nums2来对nums1赋值
                nums1[i] = nums2[point2++];
            }
        }
//        PrintUtil.printArray(nums1);
    }
}

/**
 * 方法2.从后往前，不需要额外数组
 */
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int point = m+ n - 1, point1 = m - 1, point2 = n - 1;
        //循环结束条件是point2 >= 0
        while (point2 >= 0) {
            if (point1 >= 0 && nums1[point1] > nums2[point2]) nums1[point--] = nums1[point1--];
            else nums1[point--] = nums2[point2--];
        }
        PrintUtil.printArray(nums1);
    }
}
public class q88 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
        solution.merge(new int[]{0}, 0, new int[]{1}, 1);
    }
}
