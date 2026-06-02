class Solution {
    public boolean isIsomorphic(String s, String t) {
        int length = s.length();
        int[] lastSeenPosS = new int[256];
        int[] lastSeenPosT = new int[256];
        
        for (int index = 0; index < length; index++) {
            char charS = s.charAt(index);
            char charT = t.charAt(index);
            if (lastSeenPosS[charS] != lastSeenPosT[charT]) {
                return false;
            }
            lastSeenPosS[charS] = index + 1;
            lastSeenPosT[charT] = index + 1;
        }
        
        return true;
    }
}