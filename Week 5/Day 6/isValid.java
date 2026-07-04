class Solution {
    public boolean isValid(String s) {
        char[] stack = new char[s.length()];
        int head = 0;

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);

            if (current == '(' || current == '{' || current == '[') {
                stack[head++] = current;
            } else {
                if (head == 0) {
                    return false;
                }
                
                char lastOpen = stack[--head];
                
                if (current == ')' && lastOpen != '(') return false;
                if (current == '}' && lastOpen != '{') return false;
                if (current == ']' && lastOpen != '[') return false;
            }
        }

        return head == 0;
    }
}