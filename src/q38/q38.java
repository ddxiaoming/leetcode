package q38;
class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        char[] chars = countAndSay(n - 1).toCharArray();
        int len = chars.length, startIndex = 0;
        StringBuilder res = new StringBuilder();
        for (int i = 1; i < len + 1; i++) {
            if (i == len) {
                res.append(i - startIndex).append(chars[startIndex]);
            } else if (chars[startIndex] != chars[i]) {
                res.append(i - startIndex).append(chars[startIndex]);
                startIndex = i;
            }
//            int j = i;
//            while (j + 1 < len && chars[j] == chars[j + 1]) j++;
//            int count = j - i + 1;
//            res.append(count).append(chars[i]);
//            i = j;
        }
        return res.toString();
    }
}
public class q38 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countAndSay(4));
    }
}
