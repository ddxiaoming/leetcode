package q28;
class Solution {
    public int strStr(String haystack, String needle) {
        //i是源字符串的指针，j是模式字符串的指针
        //KMP算法的源字符串的指针不需要回退
        int i = 0, j = 0, len1 = haystack.length(), len2 = needle.length();
        if (len2 == 0) return 0;
        char[] s = haystack.toCharArray();//源字符串
        char[] p = needle.toCharArray();//模式串
        int[] next = getNext(p);
        while (i < len1) {
            if (s[i] == p[j]) {//当前位置匹配成功，两个指针都后移
                i++;
                j++;
            } else if (j == 0) {//模式字符串第一个字符便不匹配，那么源字符串指针后移
                i++;
            } else {
                j = next[j - 1];//模式字符串的指针回退
            }
            if (j == len2) return i - len2;//模式字符串指针指向末尾，代表找到了
        }
        return -1;
    }
    //求模式串needle的next数组
    public int[] getNext(char[] p) {
        int len = p.length;
        int[] next = new int[len];
        //初始化next数组
        next[0] = 0;
        //i代表前缀末尾，j代表后缀末尾
        int i = 0, j = 1;
        while (j < len) {
            if (p[i] == p[j]) {
                next[j] = i + 1;
                i++;
                j++;
            } else if (i > 0) {
                i = next[i - 1];
            } else {
                next[j] = 0;
                j++;
            }
        }
        return next;
    }
}
//"mississippi"
//"issip"
public class q28 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] next = solution.getNext("mississippi".toCharArray());
        for (int i: next){
            System.out.print(i + " ");
        }
        System.out.println();
        int index = solution.strStr("mississippi", "issip");
        System.out.println(index);
    }
}

