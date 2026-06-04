import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String frequencySort(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        Map<Character, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        List<Character>[] buckets = new List[s.length() + 1];
        
        for (char ch : freqMap.keySet()) {
            int frequency = freqMap.get(ch);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(ch);
        }

        StringBuilder result = new StringBuilder();
        for (int freq = buckets.length - 1; freq > 0; freq--) {
            if (buckets[freq] != null) {
                for (char ch : buckets[freq]) {
                    for (int k = 0; k < freq; k++) {
                        result.append(ch);
                    }
                }
            }
        }

        return result.toString();
    }
}
