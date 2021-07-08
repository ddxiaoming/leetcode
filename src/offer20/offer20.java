package offer20;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isNumber(String s) {
        // 去掉首尾空格
        s = s.trim();
        int eIndex = -1;
        SmallNumberAutoMachine sac = new SmallNumberAutoMachine();
        IntegerAutoMachine iac = new IntegerAutoMachine();

        if (s.contains("e")) eIndex = s.indexOf("e");
        else if (s.contains("E")) eIndex = s.indexOf("E");
        // 不含指数部分
        if (eIndex == -1) return iac.isInteger(s) || sac.isSmallNumber(s);
        else {
            //符号e之前的数
            String before = s.substring(0, eIndex);
            //符号e之后的指数
            String after = s.substring(eIndex + 1);
            return (iac.isInteger(before) || sac.isSmallNumber(before)) && iac.isInteger(after);
        }
    }
}

/**
 * 小数自动机
 */
class SmallNumberAutoMachine {
    private enum State {
        START,
        SIGN,
        NUMBER,
        DOT_NONUMBER,
        END
    }
    private enum CharType {
        NUMBER, // 0~9
        SIGN, // + -
        DOT, // .
        ILLEGAL // 不合法的字符
    }
    // 自动机的状态转换映射
    private final Map<State, Map<CharType, State>> transferMap;
    public SmallNumberAutoMachine() {
        transferMap = new HashMap<>();
        // State = START的状态映射
        Map<CharType, State> startMap = new HashMap<>();
        startMap.put(CharType.NUMBER, State.NUMBER);
        startMap.put(CharType.SIGN, State.SIGN);
        startMap.put(CharType.DOT, State.DOT_NONUMBER);
        transferMap.put(State.START, startMap);

        // State = SIGN的状态映射
        Map<CharType, State> signMap = new HashMap<>();
        signMap.put(CharType.NUMBER, State.NUMBER);
        signMap.put(CharType.DOT, State.DOT_NONUMBER);
        transferMap.put(State.SIGN, signMap);

        // State = NUMBER的状态映射
        Map<CharType, State> numberMap = new HashMap<>();
        numberMap.put(CharType.NUMBER, State.NUMBER);
        numberMap.put(CharType.DOT, State.END);
        transferMap.put(State.NUMBER, numberMap);

        // State = NUMBER的状态映射
        Map<CharType, State> dotNoNumberMap = new HashMap<>();
        dotNoNumberMap.put(CharType.NUMBER, State.END);
        transferMap.put(State.DOT_NONUMBER, dotNoNumberMap);

        // State = END的状态映射
        Map<CharType, State> endMap = new HashMap<>();
        endMap.put(CharType.NUMBER, State.END);
        transferMap.put(State.END, endMap);
    }

    public boolean isSmallNumber(String s) {
        char[] array = s.toCharArray();
        State state = State.START;
        for (char c : array) {
            CharType charType = getCharType(c);
            // 当前状态遇到不合法的输入
            if (!transferMap.get(state).containsKey(charType)) return false;
            else state = transferMap.get(state).get(charType);
        }
        return state == State.END;
    }

    private CharType getCharType(char c) {
        if (c == '+' || c == '-') return CharType.SIGN;
        if ('0' <= c && c <= '9') return CharType.NUMBER;
        if (c == '.') return CharType.DOT;
        return CharType.ILLEGAL;
    }
}

/**
 * 整数自动机
 */
class IntegerAutoMachine {
    private enum State {
        START,
        SIGN,
        END
    }
    private enum CharType {
        NUMBER, // 0~9
        SIGN, // + -
        ILLEGAL // 不合法的字符
    }
    // 自动机的状态转换映射
    private final Map<State, Map<CharType, State>> transferMap;
    public IntegerAutoMachine() {
        transferMap = new HashMap<>();
        // State = START的状态映射
        Map<CharType, State> startMap = new HashMap<>();
        startMap.put(CharType.NUMBER, State.END);
        startMap.put(CharType.SIGN, State.SIGN);
        transferMap.put(State.START, startMap);

        // State = SIGN的状态映射
        Map<CharType, State> signMap = new HashMap<>();
        signMap.put(CharType.NUMBER, State.END);
        transferMap.put(State.SIGN, signMap);

        // State = END的状态映射
        Map<CharType, State> endMap = new HashMap<>();
        endMap.put(CharType.NUMBER, State.END);
        transferMap.put(State.END, endMap);
    }

    public boolean isInteger(String s) {
        char[] array = s.toCharArray();
        State state = State.START;
        for (char c : array) {
            CharType charType = getCharType(c);
            // 当前状态遇到不合法的输入
            if (!transferMap.get(state).containsKey(charType)) return false;
            else state = transferMap.get(state).get(charType);
        }
        return state == State.END;
    }

    private CharType getCharType(char c) {
        if (c == '+' || c == '-') return CharType.SIGN;
        if ('0' <= c && c <= '9') return CharType.NUMBER;
        return CharType.ILLEGAL;
    }
}
public class offer20 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // "+100", "5e2", "-123", "3.1416", "-1E-16", "0123"
        System.out.println(solution.isNumber("+100"));
        System.out.println(solution.isNumber("5e2"));
        System.out.println(solution.isNumber("-123"));
        System.out.println(solution.isNumber("3.1416"));
        System.out.println(solution.isNumber("-1E-16"));
        System.out.println(solution.isNumber("0123"));
        System.out.println("--------------------false----------------------");

        // "12e", "1a3.14", "1.2.3", "+-5", "12e+5.4"
        System.out.println(solution.isNumber("12e"));
        System.out.println(solution.isNumber("1a3.14"));
        System.out.println(solution.isNumber("1.2.3"));
        System.out.println(solution.isNumber("+-5"));
        System.out.println(solution.isNumber("12e+5.4"));
    }
}
