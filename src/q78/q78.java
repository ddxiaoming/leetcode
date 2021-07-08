package q78;

import util.PrintUtil;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private final List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        //跑一遍dfs，每一次都把list结果加入进去
        dfs(nums, 0, new ArrayList<>());
        return ans;
    }
    private void dfs(int[] nums, int start, List<Integer> path) {
        ans.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            //注意：小细节，下一次dfs的start应该为i + 1，而不是start + 1
            //不小心写错了，排查了好久
            dfs(nums, i + 1, path);
            path.remove(path.size() - 1);
        }
    }
}

public class q78 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> ans;
        ans = solution.subsets(new int[]{1, 2, 3, 4});
        PrintUtil.printList(ans);
    }
}
