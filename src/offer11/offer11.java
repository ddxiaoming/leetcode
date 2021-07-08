package offer11;

/**
 * 做二分查找类题目的时候，要注意不要进入死循环。
 * 什么时候才可能会进入到死循环呢？两种情况：
 * 1. 当mid = (left + right) / 2 = left时，因此假如下一次循环的时候令left = mid，则会陷入死循环，一般的二分查找里面是令left = mid + 1
 * 2. 当mid = (left + right) / 2 = right时，因此假如下一次循环的时候令right = mid，则会陷入死循环，一般的二分查找里面是令right = mid - 1
 *
 * 我们分析一下这一题会不会进入死循环
 * 1. 当mid = (left + right) / 2 = left时，由于下一次循环left = mid + 1，不会进入死循环
 * 2. 当mid = (left + right) / 2 = right时，由于numbers[mid] = numbers[right]，下一次循环时right--，不会进入死循环
 */
class Solution {
    public int minArray(int[] numbers) {
        int left = 0, right = numbers.length - 1;
        while (left != right) {
            int mid = (left + right) / 2;
            if (numbers[mid] < numbers[right]) {
                right = mid;
            } else if (numbers[mid] > numbers[right]) {
                // 为什么这里可以是mid + 1，因为numbers[mid] > numbers[right]，mid不可能是最小值，可以跳过
                left = mid + 1;
            } else {
                right--;
            }
        }
        return numbers[left];
    }
}
public class offer11 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minArray(new int[]{0, 1, 2}));
    }
}
