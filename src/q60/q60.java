package q60;
class Solution {
    private int count = 0;
    private String ans = "";
    public String getPermutation(int n, int k) {
        dfs(0, n, k, new StringBuilder(), new boolean[n]);
        return ans;
    }
    private void dfs (int depth, int n, int k, StringBuilder s, boolean[] visit) {
        if (depth == n) {
            count++;
        }
        if (count == k) {
            ans =  s.toString();
            return;
        } else if (count > k){
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                s.append(i + 1);
                dfs(depth+1, n, k, s, visit);
                if (count >= k) return;
                s.deleteCharAt(s.length() - 1);
                visit[i] = false;
            }
        }
    }
}
public class q60 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getPermutation(3,1));
    }
}
