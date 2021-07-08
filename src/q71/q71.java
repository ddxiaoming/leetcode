package q71;

import java.util.ArrayList;

class Solution {
    public String simplifyPath(String path) {
        StringBuilder ans = new StringBuilder();
        //记录每一个目录项的起始位置
        ArrayList<Integer> start = new ArrayList<>();
        String[] split = path.split("/");
        for (String str : split) {
            if (str.equals("..") && start.size() > 0) {
                ans.delete(start.get(start.size() - 1), ans.length());
                start.remove(start.size() - 1);
            } else if (!str.equals(".") && !str.equals("") && !str.equals("..")) {
                start.add(ans.length());
                ans.append("/");
                ans.append(str);
            }
        }
        //说明当前目录是根目录
        if (ans.length() == 0) ans.append("/");
        return ans.toString();
    }
}
public class q71 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.simplifyPath("/home/"));
        System.out.println(solution.simplifyPath("/../"));
        System.out.println(solution.simplifyPath("/home//foo/"));
        System.out.println(solution.simplifyPath("/a/./b/../../c/"));
        System.out.println(solution.simplifyPath("/home/of/foo/../../bar/../../is/./here/."));
    }
}
