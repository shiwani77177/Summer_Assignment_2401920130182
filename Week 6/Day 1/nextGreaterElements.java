//import java.util.Arrays;
//import java.util.Stack;

public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        
        int totalElements = nums.length;
        int[] nextGreater = new int[totalElements];
        Arrays.fill(nextGreater, -1);
        
        Stack<Integer> indexTracker = new Stack<>();
        
        int doubleBoundary = totalElements * 2;
        for (int step = 0; step < doubleBoundary; step++) {
            int virtualIndex = step % totalElements;
            int currentVal = nums[virtualIndex];
            
            while (!indexTracker.isEmpty() && nums[indexTracker.peek()] < currentVal) {
                int resolvedIndex = indexTracker.pop();
                nextGreater[resolvedIndex] = currentVal;
            }
            
            if (step < totalElements) {
                indexTracker.push(virtualIndex);
            }
        }
        
        return nextGreater;
    }
}