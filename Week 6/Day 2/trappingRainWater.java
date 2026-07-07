class Solution {
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }

        int low = 0;
        int high = height.length - 1;
        
        int currentLeftPeak = 0;
        int currentRightPeak = 0;
        int totalCapturedWater = 0;

        while (low <= high) {
            if (height[low] <= height[high]) {
                if (height[low] >= currentLeftPeak) {
                    currentLeftPeak = height[low];
                } else {
                    totalCapturedWater += currentLeftPeak - height[low];
                }
                low++;
            } else {
                if (height[high] >= currentRightPeak) {
                    currentRightPeak = height[high];
                } else {
                    totalCapturedWater += currentRightPeak - height[high];
                }
                high--;
            }
        }

        return totalCapturedWater;
    }
}