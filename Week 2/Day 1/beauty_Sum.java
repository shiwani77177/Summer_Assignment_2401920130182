class Solution {
    public int beautySum(String s) {
        int totalBeauty = 0;
        int stringLength = s.length();

        for (int i = 0; i < stringLength; i++) {
            int[] charFrequencies = new int[26];
            
            for (int j = i; j < stringLength; j++) {
                charFrequencies[s.charAt(j) - 'a']++;
                
                int maxFreq = 0;
                int minFreq = Integer.MAX_VALUE;
                
                for (int freq : charFrequencies) {
                    if (freq > maxFreq) {
                        maxFreq = freq;
                    }
                    if (freq > 0 && freq < minFreq) {
                        minFreq = freq;
                    }
                }
                
                if (maxFreq > minFreq) {
                    totalBeauty += (maxFreq - minFreq);
                }
            }
        }
        
        return totalBeauty;
    }
}
