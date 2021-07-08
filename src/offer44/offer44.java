package offer44;
class Solution {
    public int findNthDigit(int n) {
        long start = 1, numLen = 1, count = 9;
        while (n > count) {
            n -= count;
            start *= 10;
            numLen += 1;
            count = 9 * start * numLen;
        }
        long num = (n - 1) / numLen + start;
        return String.valueOf(num).charAt((int) ((n - 1) % numLen)) - '0';
    }
}
public class offer44 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findNthDigit(3));
        System.out.println(solution.findNthDigit(11));
        System.out.println(solution.findNthDigit(1000000000));
    }
}
