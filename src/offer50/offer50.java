package offer50;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public char firstUniqChar(String s) {
        char[] array = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : array) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : array) {
            if (map.get(c) == 1) return c;
        }
        return ' ';
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("开启线程" + getName());
    }
}
public class offer50 {
    public static void main(String[] args) {
        Thread t = new MyThread();
        t.start();
    }
}
