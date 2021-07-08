package offer38;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    List<String> res = new ArrayList<>();
    public String[] permutation(String s) {
        char[] array = s.toCharArray();
        Arrays.sort(array);
        dfs(0, new StringBuilder(), array, new boolean[array.length]);
        return res.toArray(new String[0]);
    }
    private void dfs(int depth, StringBuilder path, char[] array, boolean[] visited) {
        if (depth == array.length) {
            res.add(path.toString());
            return;
        }
        for (int i = 0; i < array.length; i++) {
            // 去重，重复的元素每一层只取一次
            if (i > 0 && !visited[i - 1] && array[i] == array[i - 1]) continue;
            if (!visited[i]) {
                visited[i] = true;
                path.append(array[i]);
                dfs(depth + 1, path, array, visited);
                path.deleteCharAt(path.length() - 1);
                visited[i] = false;
            }
        }
    }
}
public class offer38 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] res = solution.permutation("abcb");
        System.out.println(Arrays.asList(res));
    }
}
