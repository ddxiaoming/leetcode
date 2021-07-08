package q90;

import util.PrintUtil;

import java.util.*;

/**
 * 90. 子集II
 */

/**
 * 回溯 + 数组排序后利用Map去重
 */
class Solution1 {
    private List<List<Integer>> ans = new ArrayList<>();
    private Map<List<Integer>, Integer> map = new HashMap<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        create(0, nums, new ArrayList<Integer>());
        return ans;
    }
    private void create(int start, int[] nums, List<Integer> subset) {
        if (!map.containsKey(subset)) {
            ans.add(new ArrayList<>(subset));
            map.put(subset, 0);
        }
        for (int i = start; i < nums.length; i++) {
            subset.add(nums[i]);
            create(i + 1, nums, subset);
            subset.remove(subset.size() - 1);
        }
    }
}

/**
 * 回溯 + 排序后跳过相同元素去重
 */
class Solution {
    private List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        create(0, nums, new ArrayList<Integer>());
        return ans;
    }
    private void create(int start, int[] nums, List<Integer> subset) {
        ans.add(new ArrayList<>(subset));
        for (int i = start; i < nums.length; i++) {
            //保证相同的数字每一层只被提取一次
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            subset.add(nums[i]);
            create(i + 1, nums, subset);
            subset.remove(subset.size() - 1);
        }
    }
}
public class q90 {
    public static void main(String[] args) {
        List<List<Integer>> ans = null;
        ans = new Solution().subsetsWithDup(new int[]{1,2,2,3});
        PrintUtil.printList(ans);

        ans = new Solution().subsetsWithDup(new int[]{1,2,3});
        PrintUtil.printList(ans);
    }
}
