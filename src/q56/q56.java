package q56;
import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, (o1, o2)-> o1[0] - o2[0]);
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if (i + 1 < intervals.length && intervals[i][1] >= intervals[i + 1][0]) {
                //合并区间
                intervals[i + 1][0] = intervals[i][0];
                intervals[i + 1][1] = Math.max(intervals[i + 1][1], intervals[i][1]);
            } else {
                list.add(intervals[i]);
            }
        }
        return list.toArray(new int[list.size()][2]);
    }
}
public class q56 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] merges = solution.merge(new int[][]{{8, 10}, {2, 6}, {1, 3}, {15, 18}});
        for (int[] merge : merges) {
            for (int x : merge) System.out.print(x + " ");
            System.out.println();
        }
        System.out.println("-----------------------");
        merges = solution.merge(new int[][]{{1, 4}, {4, 5}});
        for (int[] merge : merges) {
            for (int x : merge) System.out.print(x + " ");
            System.out.println();
        }
        System.out.println("-----------------------");
        merges = solution.merge(new int[][]{{1, 4}, {2, 3}});
        for (int[] merge : merges) {
            for (int x : merge) System.out.print(x + " ");
            System.out.println();
        }

        System.out.println("-----------------------");
        merges = solution.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
        for (int[] merge : merges) {
            for (int x : merge) System.out.print(x + " ");
            System.out.println();
        }

        System.out.println("-----------------------");
        merges = solution.merge(new int[][]{{2,3},{2,2},{3,3},{1,3},{5,7},{2,2},{4,6}});
        for (int[] merge : merges) {
            for (int x : merge) System.out.print(x + " ");
            System.out.println();
        }
    }
}
