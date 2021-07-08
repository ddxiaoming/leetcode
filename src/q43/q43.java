package q43;

class Solution {
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) return "0";
        int len1 = num1.length(), len2 = num2.length();
        //乘积的结果为len1 + len2 位
        int[] ans = new int[len1 + len2];
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                //num1[i] * num2[j]的结果应该放在ans[i + j + 1]中
                int x = chars1[i] - '0';
                int y = chars2[j] - '0';
                ans[i + j + 1] += x * y;
            }
        }

        //再次倒序遍历处理进位
        for (int i = ans.length - 1; i > 0; i--) {
            ans[i - 1] += ans[i] / 10;
            ans[i] %= 10;
        }

        //将结果转为字符串形式
        int index = ans[0] == 0 ? 1 : 0;
        StringBuilder sb = new StringBuilder();
        for (int i = index; i < ans.length; i++) {
            sb.append(ans[i]);
        }
        return sb.toString();
    }
}
public class q43 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.multiply("123","456"));
    }
}
