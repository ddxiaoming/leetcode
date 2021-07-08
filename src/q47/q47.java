package q47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        dfs(0,nums, new ArrayList<>(), nums.length, new boolean[nums.length]);
        return res;
    }
    private void dfs(int depth, int[] nums, ArrayList<Integer> list, int len, boolean[] visit) {
        if (depth == len) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (i - 1 >= 0 && nums[i] == nums[i - 1] && !visit[i - 1]) continue;
            if (!visit[i]) {
                visit[i] = true;
                list.add(nums[i]);
                dfs(depth + 1, nums, list, len, visit);
                list.remove(list.size() - 1);
                visit[i] = false;
            }
        }
    }
}
public class q47 {
    public static void main(String[] args) {
        System.out.println(new Solution().permuteUnique(new int[]{1,1,2}));
        System.out.println(new Solution().permuteUnique(new int[]{1,2,3}));
        System.out.println(new Solution().permuteUnique(new int[]{1,1,1,2}));
        System.out.println(new Solution().permuteUnique(new int[]{1,2,3}));
    }

}
