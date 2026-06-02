class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int charIndex = 0;
        boolean mismatchFound = false;
        while (charIndex < strs[0].length()) {
            char targetChar = strs[0].charAt(charIndex);
            for (int strIndex = 1; strIndex < strs.length; strIndex++) {
                if (charIndex >= strs[strIndex].length() || strs[strIndex].charAt(charIndex) != targetChar) {
                    mismatchFound = true;
                    break;
                }
            }
            if (mismatchFound) {
                break;
            }
            
            charIndex++;
        }
        return strs[0].substring(0, charIndex);
    }
}