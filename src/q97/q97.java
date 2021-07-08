package q97;
class Solution {
    int[][] cache;//备忘录
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        char[] array1 = s1.toCharArray();
        char[] array2 = s2.toCharArray();
        char[] array3 = s3.toCharArray();
        cache = new int[len1 + 1][len2 + 1];
        return isInterleave(array1, array2, array3, len1, len2, len3,0, 0, 0);
    }
    private boolean isInterleave(char[] s1, char[] s2, char[] s3, int len1, int len2, int len3, int p1, int p2, int p3) {
        if (p3 == len3 && p2 == len2 && p1 == len1) {
            return true;
        }

        if (cache[p1][p2] == 1) return true;
        else if (cache[p1][p2] == 2) return false;

        boolean flag1 = false, flag2 = false;
        if (p1 < len1 && p3 < len3 && s1[p1] == s3[p3]) {
            flag1 = isInterleave(s1, s2, s3, len1, len2, len3, p1 + 1, p2, p3 + 1);
        }
        if (p2 < len2 && p3 < len3 && s2[p2] == s3[p3]) {
            flag2 = isInterleave(s1, s2, s3, len1, len2, len3, p1, p2 + 1, p3 + 1);
        }
        boolean flag = flag1 || flag2;
        cache[p1][p2] = flag ? 1 : 2;
        return flag;
    }
}
public class q97 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(new Solution().isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(new Solution().isInterleave("aabcc", "dbbca", "aadbbbaccc"));
        System.out.println(new Solution().isInterleave("", "", ""));
    }
}
