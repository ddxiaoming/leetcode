package q57;

import java.util.ArrayList;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0], right = newInterval[1];
        int len = intervals.length;
        //newInterval是否已经添加进结果集合中
        boolean flag = false;
        ArrayList<int[]> res = new ArrayList<>();
        for (int[] interval : intervals) {
            //将合并后的区间添加进结果集合中
            if (!flag && interval[0] > right) {
                res.add(new int[]{left, right});
                flag = true;
            }
            if (interval[1] < left || interval[0] > right) {//当前区间不需要合并
                res.add(interval);
            } else {//合并区间并更新左右端点
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }
        //newInterval还未被添加进结果集合中，说明newInterval需要被插入到末尾
        if (!flag) res.add(new int[]{left, right});
        return res.toArray(new int[res.size()][2]);
    }
}
public class q57 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] result = solution.insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5});
        for (int[] merge : result) {
            for (int x : merge) System.out.print(x + " ");
            System.out.println();
        }

        System.out.println();
        result = solution.insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8});
        for (int[] merge : result) {
            for (int x : merge) System.out.print(x + " ");
            System.out.println();
        }

        System.out.println();
        result = solution.insert(new int[][]{}, new int[]{5, 7});
        for (int[] merge : result) {
            for (int x : merge) System.out.print(x + " ");
            System.out.println();
        }
    }
}
