class Solution {
    public int sumSubarrayMins(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        
        int len = arr.length;
        long cumulativeTotal = 0;
        long moduloDivisor = 1000000007;
        
        int[] leftBoundDist = new int[len];
        int[] rightBoundDist = new int[len];
        
        int[] indexStack = new int[len + 1];
        int stackPointer = 0;
        
        for (int i = 0; i < len; i++) {
            while (stackPointer > 0 && arr[indexStack[stackPointer - 1]] >= arr[i]) {
                stackPointer--;
            }
            leftBoundDist[i] = (stackPointer == 0) ? (i + 1) : (i - indexStack[stackPointer - 1]);
            indexStack[stackPointer++] = i;
        }
        
        stackPointer = 0;
        
        for (int i = len - 1; i >= 0; i--) {
            while (stackPointer > 0 && arr[indexStack[stackPointer - 1]] > arr[i]) {
                stackPointer--;
            }
            rightBoundDist[i] = (stackPointer == 0) ? (len - i) : (indexStack[stackPointer - 1] - i);
            indexStack[stackPointer++] = i;
        }
        
        for (int i = 0; i < len; i++) {
            long contributionCount = (long) leftBoundDist[i] * rightBoundDist[i];
            long subtotal = (contributionCount * arr[i]) % moduloDivisor;
            cumulativeTotal = (cumulativeTotal + subtotal) % moduloDivisor;
        }
        
        return (int) cumulativeTotal;
    }
}
