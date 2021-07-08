package offer48;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0, res = 0;
        Set<Character> set = new HashSet<>();
        while (right < s.length()){
            char c = s.charAt(right);
            if (!set.contains(c)) {
                // 移动右指针
                set.add(c);
                right++;
            } else {
                // 移除set中的重复元素，并向右移动左指针
                set.remove(s.charAt(left));
                left++;
            }
            res = Math.max(res, set.size());
        }
        return res;
    }
}

public class offer48 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
        System.out.println(solution.lengthOfLongestSubstring("abcdefg"));
        System.out.println(solution.lengthOfLongestSubstring(" "));
    }
}
