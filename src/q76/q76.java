package q76;

import java.util.HashMap;
import java.util.Map;

/**
 * MAP的解法
 */
class Solution2 {
    public String minWindow(String s, String t) {
        String ans = "";
        //字符串t与滑动窗口的字符频度数组
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        //初始化tMap
        for (char c : tArray) tMap.put(c, tMap.getOrDefault(c, 0) + 1);

        //distance反映两个字符频度数组的接近程度，当 distance = tMap.size()时，滑动窗口中包含t的所有元素
        int distance = 0, target = tMap.size();
        int left = 0, right = 0;
        int sLen = s.length();

        while (right < sLen) {
            while (right < sLen && distance != target) {
                char c = sArray[right++];
                windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
                if (windowMap.get(c).equals(tMap.get(c))) distance++;
            }
            //此窗口扩展到最大（右边界 = s.length）也无法包含t中全部字符
            if (distance != target) break;

            while (left < sLen && distance == target) {
                char c = sArray[left++];
                windowMap.put(c, windowMap.getOrDefault(c, 0) - 1);
                if (tMap.containsKey(c) && windowMap.get(c) < tMap.get(c)) distance--;
            }

            String windowStr = s.substring(left - 1, right);
            ans = ans.equals("") ? windowStr : ans.length() > windowStr.length() ? windowStr : ans;
        }
        return ans;
    }
}

class Solution {
    public String minWindow(String s, String t) {
        String ans = "";
        //字符串t与滑动窗口的字符频度数组
        int[] tFreq= new int[128];
        int[] windowFreq = new int[128];

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        //初始化tFreq
        for (char c : tArray) tFreq[c]++;

        //distance反映两个字符频度数组的接近程度，当 distance = t.length()时，滑动窗口中包含t的所有元素
        int distance = 0;
        //窗口左右边界初始化为0
        int left = 0, right = 0;
        int sLen = s.length(), tLen = t.length();

        //这两个变量记录滑动窗口的位置以及长度，因为最终结果的计算涉及到subString字符串操作，非常耗时
        //如果每次得到一个窗口都进行一次subString操作的话，很浪费时间
        //因此维护这两个变量，将subString操作推迟到最后进行（且只进行一次），节省时间
        int start = 0, minLen = sLen + 1;

        while (right < sLen) {

            //窗口右边界右移，扩张窗口，找到一个符合条件的，能涵盖t中所有字符的窗口
            while (right < sLen && distance != tLen) {
                char c = sArray[right++];
                if (windowFreq[c] < tFreq[c]) distance++;
                windowFreq[c]++;
            }

            //此窗口扩展到最大（右边界 = s.length）也无法包含t中全部字符
            //因此此时无论窗口左边界向右怎么移动，都无法找到一个符合条件涵盖t中所有字符的窗口
            //循环直接结束
            if (distance != tLen) break;

            //窗口左边界右移，收缩窗口，将当前窗口收缩的尽可能地小，当窗口无法涵盖t中所有字符时，循环结束
            while (left < sLen && distance == tLen) {
                char c = sArray[left++];
                if (windowFreq[c] == tFreq[c]) distance--;
                windowFreq[c]--;
            }

            //当前满足条件的窗口左边界应该为left - 1，因为在收缩的过程中，循环结束条件是窗口无法涵盖t中所有字符
            //因此当循环结束，得到的窗口是不满足条件的窗口，将left往前推1位，便可得到最小的满足条件的窗口
            //因此当前窗口长度就是right - (left - 1)
            int len = right - left + 1;
            //更新窗口的最小长度
            if (minLen > len) {
                minLen = len;
                start = left - 1;
            }
        }
        return minLen == sLen + 1 ? "" : s.substring(start, start + minLen);
    }
}
public class q76 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(solution.minWindow("a", "a"));
        System.out.println(solution.minWindow("a", "aa"));
        System.out.println(solution.minWindow("aa", "aa"));
    }
}
