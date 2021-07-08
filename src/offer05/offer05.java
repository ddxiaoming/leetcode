package offer05;

import java.util.Arrays;

/**
 * 方法 1.原地替换
 * 从后往前
 */
class Solution {
    public String replaceSpace(String s) {
        //空格数量
        int spaceNum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') spaceNum++;
        }
        //新数组
        char[] array = Arrays.copyOf(s.toCharArray(), s.length() + 2 * spaceNum);
        //i指向旧数组末尾，j指向新数组末尾
        int i = s.length() - 1, j = array.length - 1;
        //当两指针相遇时，代表所有空格都已经处理完毕，循环结束
        while (i != j) {
            if (array[i] == ' ') {
                array[j--] = '0';
                array[j--] = '2';
                array[j--] = '%';
            } else {
                array[j--] = array[i];
            }
            i--;
        }
        return new String(array);
    }
}

/**
 * 方法 2.从前往后，使用StringBuilder(也可以使用char数组)
 */
class Solution2 {
    public String replaceSpace(String s) {
        //StringBuilder初始化大小为16，空间不够时会自动扩容
        //可以手动指定StringBuilder的大小为 3 * s.length，防止动态扩容带来的性能损耗（因为最坏的情况是全都是空格）
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') sb.append("%20");
            else sb.append(c);
        }
        return sb.toString();
    }
}

public class offer05 {
    public static void main(String[] args) {
        System.out.println(new Solution().replaceSpace("We are happy."));
    }
}
