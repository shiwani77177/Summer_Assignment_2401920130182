class Solution {
    public boolean check(int[] nums) {
        int length = nums.length;
        int breakCount = 0;
        
        for (int i = 0; i < length; i++) {
            if (nums[i] > nums[(i + 1) % length]) {
                breakCount++;
            }
            if (breakCount > 1) {
                return false;
            }
        }
        
        return true;
    }
}
