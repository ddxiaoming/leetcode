package q68;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int start = 0, end = 0;
        while (start < words.length) {
            StringBuilder rowString = new StringBuilder();//每一行的字符串
            int rowWordsLen = 0;//当前行的纯单词长度
            int rowLen = 0;//当前行的纯单词 + 空格长度（假设每两个单词间最少一个空格）

            //找到每一行所能存放单词的起始位置和结束位置
            for (int i = start; i < words.length; i++) {
                rowWordsLen += words[i].length();
                rowLen = rowWordsLen + i - start;
                if (rowLen <= maxWidth) {
                    end = i + 1;
                } else {
                    rowWordsLen -= words[i].length();
                    break;
                }
            }

            int rowWordsNum = end - start;//当前行的单词个数
            int sumSpaceNum = maxWidth - rowWordsLen;//当前行总共需要填充的空格数
            int filledSpaceNum = 0;//当前行已经填充的空格数

            //如果当前行只有一个单词，这俩变量需要特殊处理
            //因为假如只有一个单词，则该行是左对齐的，单词后面需要补满空格
            int avgSpaceNum = rowWordsNum == 1 ? maxWidth - rowWordsLen : (maxWidth - rowWordsLen) / (rowWordsNum - 1);
            int leftSpaceNum = rowWordsNum == 1 ? 0: (maxWidth - rowWordsLen) % (rowWordsNum - 1);

            for (int i = start; i < end; i++) {
                //当前单词后面需要填充的空格数
                int spaceNum = 0;

                //文本的其它行（即除了最后一行）两端对齐
                if (leftSpaceNum > 0) {
                    spaceNum += avgSpaceNum + 1;
                    leftSpaceNum--;
                } else {
                    spaceNum = avgSpaceNum;
                }

                //文本的最后一行左对齐
                if (end == words.length) {
                    if (i == words.length - 1) spaceNum = sumSpaceNum - filledSpaceNum;
                    else spaceNum = 1;
                }

                rowString.append(words[i]);
                if (filledSpaceNum < sumSpaceNum) rowString.append(geneSpace(spaceNum));
                filledSpaceNum += spaceNum;
            }
            ans.add(rowString.toString());
            start = end;
        }
        return ans;
    }

    private String geneSpace(int num) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < num; i++) ans.append(' ');
        return ans.toString();
    }
}
public class q68 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16));
        System.out.println(solution.fullJustify(new String[]{"This", "is"}, 16));
        System.out.println(solution.fullJustify(new String[]{"What","must","be","acknowledgment","shall","be"}, 16));
        System.out.println(solution.fullJustify(new String[]{"Science","is","what","we","understand","well","enough","to","explain", "to","a","computer.","Art","is","everything","else","we","do"}, 20));
    }
}
