package q49;

import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, ArrayList<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            //将字符串排成字典序
            String sortedStr = String.copyValueOf(chars);
            if (! map.containsKey(sortedStr)) {
                //将字典序的字符串和新数组添加进map中
                map.put(sortedStr, new ArrayList<>());
            }
            //将字母异位词组合在一起
            map.get(sortedStr).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
public class q49 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
