package q58;
class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int index = s.lastIndexOf(' ');
        return index > -1 ? s.length() - index - 1 : s.length();
    }
}
public class q58 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLastWord("Hello World"));
        System.out.println(solution.lengthOfLastWord("Hello World  J"));
        System.out.println(solution.lengthOfLastWord("Hell  "));
    }
}
