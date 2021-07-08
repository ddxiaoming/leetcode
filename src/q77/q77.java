package q77;

import util.PrintUtil;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        dfs(1, n, k, 0, new ArrayList<>());
        return ans;
    }
    private void dfs(int start, int n, int k, int depth, List<Integer> list) {
        if (depth == k) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= n - (k - list.size()) + 1; i++) {
            list.add(i);
            dfs(i + 1, n, k, depth + 1, list);
            list.remove(list.size() - 1);
        }
    }
}
public class q77 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> ans;
        ans = solution.combine(4, 2);
        PrintUtil.printList(ans);
    }
}
