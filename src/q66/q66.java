package q66;


class Solution {
    public int[] plusOne(int[] digits) {
        int adder = 1;
        for (int i = digits.length - 1; i >=0; i--) {
            if (adder <= 0) break;
            int num = digits[i] + adder;
            digits[i] = (num) % 10;
            adder = (num) / 10;
        }
        if (adder == 0) return digits;
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }
}
public class q66 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        printArray(solution.plusOne(new int[]{0}));
    }
    private static void printArray(int[] objects) {
        for (int o : objects) System.out.print(o);
        System.out.println();
    }
}
