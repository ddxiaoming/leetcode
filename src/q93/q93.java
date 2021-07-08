package q93;

import util.PrintUtil;

import java.util.ArrayList;
import java.util.List;

class Solution1 {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        int len = s.length();
        if(len > 12) return ans;
        for (int i = 0; i < len; i++) {

            StringBuilder sb1 = new StringBuilder();
            String sub = s.substring(0, i + 1);
            if (!check(sub)) continue;
            else sb1.append(sub).append(".");

            for (int j = i + 1; j < len; j++) {
                StringBuilder sb2 = new StringBuilder(sb1);
                sub = s.substring(i + 1, j + 1);
                if (!check(sub)) continue;
                else sb2.append(sub).append(".");

                for (int k = j + 1; k < len; k++) {

                    StringBuilder sb3 = new StringBuilder(sb2);
                    sub = s.substring(j + 1, k + 1);
                    String sub2 = s.substring(k + 1, len);
                    if (check(sub) && check(sub2)) {
                        sb3.append(sub).append(".");
                        sb3.append(sub2);
                        ans.add(sb3.toString());
                    }
                }
            }
        }
        return ans;
    }
    //判断一个字符串是否满足0-255且不能有前导0的规则
    private boolean check(String num) {
        return num.length() > 0 && num.length() < 4 && (num.charAt(0) != '0' || num.length() <= 1) && Integer.parseInt(num) <= 255;
    }
}

class Solution {
    private static final int MAX_DEPTH = 4;//树的最大深度
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        backTrace(ans, new StringBuilder(), 0, 0, s);
        return ans;
    }
    //depth表示当前深度，即已经分割出的ip段的个数，start表示当前需要从哪个位置继续寻找下一个ip段
    private void backTrace(List<String> ans, StringBuilder path, int depth, int start, String s) {
        if (depth == MAX_DEPTH) {
            //此时找到了一个解
            if (start == s.length()) {
                //去掉最后加的“.”
                path.deleteCharAt(path.length() - 1);
                ans.add(path.toString());
            }
            //不管找没找到解，此时该分支不能再继续进行下去了
            return;
        }
        //还没找到四段ip地址就已经遍历完字符串了，提前回溯，剪枝
        if (start == s.length()) return;
        int ip = 0;
        //方便回溯
        int oldLen = path.length();
        boolean isZero = s.charAt(start) == '0';
        for (int i = start; i < s.length(); i++) {
            ip = ip * 10 + (s.charAt(i) - '0');
            //该ip段有前导0，直接剪枝，回溯
            if (isZero && i > start) {
                return;
            }
            //判断该ip段是否满足条件
            if (0 <= ip && ip <= 255) {
                path.append(ip);
                path.append('.');
                backTrace(ans, path, depth + 1, i + 1, s);
                path.setLength(oldLen);
            }
        }
    }
}
public class q93 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.restoreIpAddresses("25525511135"));
        System.out.println(solution.restoreIpAddresses("0000"));
        System.out.println(solution.restoreIpAddresses("1111"));
        System.out.println(solution.restoreIpAddresses("010010"));
        System.out.println(solution.restoreIpAddresses("101023"));
    }
}
