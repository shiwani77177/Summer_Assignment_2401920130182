class Solution {
    public long subArrayRanges(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        return calculateSubarrayExtremaSum(nums, true) - calculateSubarrayExtremaSum(nums, false);
    }

    private long calculateSubarrayExtremaSum(int[] nums, boolean findMax) {
        int totalElements = nums.length;
        long totalSum = 0;
        
        int[] indexStack = new int[totalElements + 1];
        int stackPointer = -1;

        for (int currentIndex = 0; currentIndex <= totalElements; currentIndex++) {
            int currentVal = (currentIndex == totalElements) ? 0 : nums[currentIndex];

            while (stackPointer >= 0) {
                int targetIndex = indexStack[stackPointer];
                int targetVal = nums[targetIndex];

                boolean shouldPop = findMax 
                    ? (currentIndex == totalElements || targetVal < currentVal)
                    : (currentIndex == totalElements || targetVal > currentVal);

                if (!shouldPop) {
                    break;
                }

                stackPointer--;
                int leftBound = (stackPointer >= 0) ? indexStack[stackPointer] : -1;
                int rightBound = currentIndex;

                long validSubarraysCount = (long) (targetIndex - leftBound) * (rightBound - targetIndex);
                totalSum += validSubarraysCount * targetVal;
            }
            
            indexStack[++stackPointer] = currentIndex;
        }

        return totalSum;
    }
}