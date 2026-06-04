import java.util.HashMap;
import java.util.Map;

class Solution {
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> lookup = new HashMap<>();
        lookup.put('I', 1);
        lookup.put('V', 5);
        lookup.put('X', 10);
        lookup.put('L', 50);
        lookup.put('C', 100);
        lookup.put('D', 500);
        lookup.put('M', 1000);

        int total = 0;
        int len = s.length();

        for (int i = 0; i < len; i++) {
            int currentVal = lookup.get(s.charAt(i));

            if (i < len - 1 && currentVal < lookup.get(s.charAt(i + 1))) {
                total -= currentVal;
            } else {
                total += currentVal;
            }
        }

        return total;
    }
}