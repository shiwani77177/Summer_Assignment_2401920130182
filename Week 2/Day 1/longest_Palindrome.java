class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }

        int maxStart = 0;
        int maxLen = 1;
        int textLength = s.length();

        for (int i = 0; i < textLength; i++) {
            int left = i, right = i;
            while (left >= 0 && right < textLength && s.charAt(left) == s.charAt(right)) {
                int currentLen = right - left + 1;
                if (currentLen > maxLen) {
                    maxStart = left;
                    maxLen = currentLen;
                }
                left--;
                right++;
            }

            left = i;
            right = i + 1;
            while (left >= 0 && right < textLength && s.charAt(left) == s.charAt(right)) {
                int currentLen = right - left + 1;
                if (currentLen > maxLen) {
                    maxStart = left;
                    maxLen = currentLen;
                }
                left--;
                right++;
            }
        }

        return s.substring(maxStart, maxStart + maxLen);
    }
}