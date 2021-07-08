package q67;


import java.util.ArrayList;

class Solution {
    public String addBinary(String a, String b) {
        int aLen = a.length(), bLen = b.length(), carry = 0;
        int maxLen = Math.max(aLen, bLen);
        StringBuilder ans = new StringBuilder();
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        for (int i = 1; i <= maxLen; i++) {
            int x = i <= aLen ? aChars[aLen - i] - '0' : 0;
            int y = i <= bLen ? bChars[bLen - i] - '0' : 0;
            ans.insert(0,(x + y + carry) % 2);
            carry = (x + y + carry) / 2;
        }
        if (carry > 0) ans.insert(0, carry);
        return ans.toString();
    }
}
public class q67 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.addBinary("11","1"));
        System.out.println(solution.addBinary("0","0"));
        System.out.println(solution.addBinary("1010","1011"));
    }
}
