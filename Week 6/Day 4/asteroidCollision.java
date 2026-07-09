class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        
        for (int ast : asteroids) {
            boolean survived = true;
            
            while (!stack.isEmpty() && stack.peek() > 0 && ast < 0) {
                int topSize = stack.peek();
                int incomingSize = Math.abs(ast);
                
                if (topSize < incomingSize) {
                    stack.pop();
                } else if (topSize == incomingSize) {
                    stack.pop();
                    survived = false; 
                    break;
                } else {
                    survived = false;
                    break;
                }
            }
            
            if (survived) {
                stack.push(ast);
            }
        }
        
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        
        return result;
    }
}