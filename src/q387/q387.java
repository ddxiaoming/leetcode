package q387;
import java.util.HashMap;
import java.util.Map;
/**
 * 解法一哈希表
 */
/*
class Solution {
    public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> hashMap = new HashMap<>();
        for (char c : chars) {
            hashMap.put(c, hashMap.getOrDefault(c,0) +1 );
        }
        for (int i = 0; i < chars.length; i++) {
            if (hashMap.get(chars[i]) == 1) return i;
        }
        return -1;
    }
}
 */
class Solution {
    public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> hashMap = new HashMap<>();
        for (char c : chars) {
            hashMap.put(c, hashMap.getOrDefault(c,0) +1 );
        }
        for (int i = 0; i < chars.length; i++) {
            if (hashMap.get(chars[i]) == 1) return i;
        }
        return -1;
    }
}

public class q387 {
}
