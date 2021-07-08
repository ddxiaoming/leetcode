package q123;

import java.util.ArrayList;

class Solution {
    public int maxProfit(int[] prices) {
        int i = 0, j = 0, len = prices.length;
        int firstMax = 0, secondMax = 0;
        //双指针找到每一个递增序列，并把递增序列的差值存入res中
        while (i < len) {
            j = i;
            while (j + 1 < len && prices[j + 1] >= prices[j]) j++;
            int num = prices[j] - prices[i];
            if (num >= firstMax) {
                secondMax = firstMax;
                firstMax = num;
            } else if (num >= secondMax) {
                secondMax = num;
            }
            i = j + 1;
        }
        return firstMax + secondMax;
    }
}
public class q123 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(new int[]{3,3,5,0,0,3,1,4}));
        System.out.println(solution.maxProfit(new int[]{1,2,3,4,5}));
        System.out.println(solution.maxProfit(new int[]{3,2,6,5,0,3}));
        System.out.println(solution.maxProfit(new int[]{1,2,4,2,5,7,2,4,9,0}));
    }
}
