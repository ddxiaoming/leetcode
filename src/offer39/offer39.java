package offer39;

import java.util.HashMap;
import java.util.Map;

/**
 * HashMap法
 */
class Solution1 {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        int up = nums.length / 2;
        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
            if (hashMap.get(num) > up) return num;
        }
        return -1;
    }
}

/**
 * 摩尔投票法
 */
class Solution {
    public int majorityElement(int[] nums) {
        int votes = 0, major = 0;
        for (int num : nums) {
            if (votes == 0) major = num;
            votes += num == major ? 1 : -1;
        }
        return major;
    }
}


public class offer39 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.majorityElement(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2}));
    }
}
