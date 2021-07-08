package q39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(0, new ArrayList<>(), candidates, target);
        return res;
    }
    private void dfs(int sum, ArrayList<Integer> currentList, int[] candidates, int target) {
        if (sum == target) {
            res.add(new ArrayList<>(currentList));
        }
        for (int num : candidates) {
            if (sum + num > target) break;
            int size = currentList.size();
            //如果该列表不是按照从小到大排列的，则直接continue，这样可以避免重复
            if (size > 0 && num < currentList.get(size - 1)) continue;
            currentList.add(num);
            dfs(sum + num, currentList, candidates, target);
            currentList.remove(size);
        }
    }
}
public class q39 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.combinationSum(new int[]{2,3,6,7}, 7));
    }
}
