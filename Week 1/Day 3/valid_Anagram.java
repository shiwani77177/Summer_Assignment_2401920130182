import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            charFrequencyMap.put(ch, charFrequencyMap.getOrDefault(ch, 0) + 1);
        }
        for (char ch : t.toCharArray()) {
            if (!charFrequencyMap.containsKey(ch)) {
                return false; 
            }
            int currentCount = charFrequencyMap.get(ch);
            if (currentCount == 1) {
                charFrequencyMap.remove(ch);
            } else {
                charFrequencyMap.put(ch, currentCount - 1);
            }
        }
        return charFrequencyMap.isEmpty();
    }
}
