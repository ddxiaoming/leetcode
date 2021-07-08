package offer45;

import java.util.Arrays;

class Solution1 {
    public String minNumber(int[] nums) {
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strings, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder sb = new StringBuilder();
        for (String str : strings) {
            sb.append(str);
        }
        return sb.toString();
    }
}

class Solution {
    public String minNumber(int[] nums) {
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }
        quickSort(strings, 0, strings.length - 1);
        StringBuilder sb = new StringBuilder();
        for (String str : strings) {
            sb.append(str);
        }
        return sb.toString();
    }
    private void quickSort(String[] nums, int start, int end) {
        if (start >= end) return;
        int pivot = partition(nums, start, end);
        quickSort(nums, start, pivot - 1);
        quickSort(nums, pivot + 1, end);
    }
    private int partition(String[] nums, int start, int end) {
        int left = start, right = end;
        String pivot = nums[start];
        while (left < right) {
            while (left < right && (pivot + nums[right]).compareTo(nums[right] + pivot) <= 0) right--;
            while (left < right && (pivot + nums[left]).compareTo(nums[left] + pivot) >= 0) left++;
            swap(nums, left, right);
        }
        swap(nums, start, left);
        return left;
    }
    private void swap(String[] nums, int x, int y) {
        if (x < 0 || y < 0 || x >= nums.length || y >= nums.length) return;
        String temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}

public class offer45 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minNumber(new int[]{3, 30, 34, 5, 9}));
        System.out.println(solution.minNumber(new int[]{10, 2}));
    }
}
