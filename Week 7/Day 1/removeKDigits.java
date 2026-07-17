class Solution {
    public String removeKdigits(String num, int k) {
        if (num.length() == k) {
            return "0";
        }
        
        StringBuilder stack = new StringBuilder();
        
        for (int i = 0; i < num.length(); i++) {
            char currentDigit = num.charAt(i);
            
            while (k > 0 && stack.length() > 0 && stack.charAt(stack.length() - 1) > currentDigit) {
                stack.deleteCharAt(stack.length() - 1);
                k--;
            }
            stack.append(currentDigit);
        }
        
        while (k > 0) {
            stack.deleteCharAt(stack.length() - 1);
            k--;
        }
        
        int nonZeroIndex = 0;
        while (nonZeroIndex < stack.length() && stack.charAt(nonZeroIndex) == '0') {
            nonZeroIndex++;
        }
        
        String result = stack.substring(nonZeroIndex);
        
        return result.isEmpty() ? "0" : result;
    }
}