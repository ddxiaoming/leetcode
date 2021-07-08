package offer03;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findRepeatNumber(int[] nums) {
        Map<Integer,Boolean> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) return num;
            map.put(num, true);
        }
        return 0;
    }
}
public class offer03 {
}
