package q40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(0,0,new ArrayList<>(),candidates,target);
        return res;
    }
    private void dfs(int start, int sum, ArrayList<Integer> list, int[] candidates, int target) {
        int len = candidates.length;
        if (sum == target) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < len; i++) {
            int num = candidates[i];
            if (num + sum > target) break;
            // 这样保证相同的元素在每一层只会被提取一次，即可去重
            if (i > start && candidates[i] == candidates[i-1]) continue;
            list.add(num);
            dfs(i+1,num+sum,list,candidates,target);
            list.remove(list.size()-1);
        }
    }
}
public class q40 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
    }
}
