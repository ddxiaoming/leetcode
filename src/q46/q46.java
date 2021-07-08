package q46;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        getAllSort(nums, visited, 0, new ArrayList<>());
        return res;
    }
    private void getAllSort(int[] nums, boolean[] visited, int depth, ArrayList<Integer> current) {
        int len = nums.length;
        if (depth == len) {
            res.add(current);
            return;
        }
        for (int i = 0; i < len; i++) {
            if (!visited[i]) {
                visited[i] = true;
                ArrayList<Integer> newCurrent = new ArrayList<>(current);
                newCurrent.add(nums[i]);
                getAllSort(nums, visited, depth + 1, newCurrent);
                visited[i] = false;
            }
        }
    }
}
public class q46 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.permute(new int[]{1,2,3,4,5,6,7,8,9}));
    }
}
