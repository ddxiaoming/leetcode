package offer43;
class Solution {
    public int countDigitOne(int n) {
        int digit = 1, high = n / 10, low = 0, cur = n % 10, res = 0;
        while (low < n) {
            if (cur == 0) res += high * digit;
            else if (cur == 1) res += high * digit + low + 1;
            else res += (high + 1) * digit;
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;
    }
}
public class offer43 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countDigitOne(12));
        System.out.println(solution.countDigitOne(13));
        System.out.println(solution.countDigitOne(1410065408));
    }
}
