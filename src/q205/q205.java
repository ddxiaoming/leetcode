package q205;

import java.util.Arrays;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        char[] map = new char[26];
        char[] sChars = s.toLowerCase().toCharArray();
        char[] tChars = t.toLowerCase().toCharArray();
        int sLen = sChars.length;
        for (int i = 0; i < sLen; i++) {
            char a = sChars[i];
            int index = tChars[i] - 'a';
            if (map[index] == 0) map[index] = a;
            tChars[i] = map[index];
        }
        return Arrays.equals(sChars, tChars);
    }
}
public class q205 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isIsomorphic("aa", "ab"));
    }
}
