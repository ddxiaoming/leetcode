package q30;
import java.util.*;
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (words == null || words.length == 0) return res;
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String word : words) {
            hashMap.put(word, hashMap.getOrDefault(word,0) + 1);
        }
        int wordLen = words[0].length();//words中一个单词的长度
        int wordsLen = wordLen * words.length;//words中所有单词的总长度
        int i, j;
        //循环找到每一个子串
        for (i = 0; i < s.length() - wordsLen + 1; i++) {
            HashMap<String, Integer> newHashMap = new HashMap<>(hashMap);
            //循环找到子串中每一个单词
            for (j = i; j < i + wordsLen; j += wordLen) {
                String sub = s.substring(j, j + wordLen);
                if (!newHashMap.containsKey(sub) || newHashMap.get(sub) == 0) break;
                newHashMap.put(sub, newHashMap.get(sub) - 1);
            }
            if (j == i + wordsLen) res.add(i);
        }
        return res;
    }
}
public class q30 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findSubstring("wordgoodgoodgoodbestword", new String[]{"foo","bar"}));
    }

}
