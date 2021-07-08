package offer40;

import util.PrintUtil;

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution1 {
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        return Arrays.copyOf(arr, k);
    }
}
class QuickSort {

    /**
     * 快速排序
     * @param values 需要进行排序的数组
     * @param left 数组的左边界
     * @param right 数组的右边界
     */
    public void quickSort(int[] values, int left, int right) {
        if (left >= right) return;
        int pivotIndex = partition(values, left, right);
        quickSort(values, left, pivotIndex - 1);
        quickSort(values, pivotIndex + 1, right);
    }

    /**
     * 划分函数
     * @param values 需要进行一次划分的数组
     * @param left 数组的左边界
     * @param right 数组的右边界
     * @return 划分后，分界值pivot所在的索引位置
     */
    private int partition(int[] values, int left, int right) {
        int pivot = values[left];
        int pivotIndex = left;
        while (left < right) {
            while (left < right && values[right] >= pivot) right--;
            while (left < right && values[left] <= pivot) left++;
            swap(values, left, right);
        }
        // 此时left = right = 边界值pivot的索引位置
        swap(values, left, pivotIndex);
        // 更新pivot的索引值
        pivotIndex = left;
        return pivotIndex;
    }

    /**
     * 交换数组中的两个元素
     */
    private void swap(int[] values, int i, int j) {
        int temp = values[i];
        values[i] = values[j];
        values[j] = temp;
    }
}

class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) return new int[0];
        quickSelect(arr, 0, arr.length - 1, k);
        return Arrays.copyOf(arr, k);
    }

    public void quickSelect(int[] values, int left, int right, int k) {
        if (left >= right) return;
        int pivotIndex = partition(values, left, right);
        if (pivotIndex + 1 > k) quickSelect(values, left, pivotIndex - 1, k);
        else if (pivotIndex + 1 < k) quickSelect(values, pivotIndex + 1, right, k);
    }

    /**
     * 划分函数
     * @param values 需要进行一次划分的数组
     * @param left 数组的左边界
     * @param right 数组的右边界
     * @return 划分后，分界值pivot所在的索引位置
     */
    private int partition(int[] values, int left, int right) {
        int pivot = values[left];
        int pivotIndex = left;
        while (left < right) {
            while (left < right && values[right] >= pivot) right--;
            while (left < right && values[left] <= pivot) left++;
            swap(values, left, right);
        }
        // 此时left = right = 边界值pivot的索引位置
        swap(values, left, pivotIndex);
        // 更新pivot的索引值
        pivotIndex = left;
        return pivotIndex;
    }

    /**
     * 交换数组中的两个元素
     */
    private void swap(int[] values, int i, int j) {
        int temp = values[i];
        values[i] = values[j];
        values[j] = temp;
    }
}

public class offer40 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] values = new int[]{2, 5, 8, 3, 4, 9, 1};
        PrintUtil.printArray(solution.getLeastNumbers(values, 0));
    }
}
