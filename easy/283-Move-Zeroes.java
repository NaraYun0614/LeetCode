class Solution {
    public void moveZeroes(int[] nums) {
        // Move all the non-zero elements in the front
        // fill out with zeros
        int count = 0;
        int len = nums.length;

        for(int num: nums) {
            if (num != 0) {
                nums[count++] = num;
            }
        }

        while (count < len) {
            nums[count++] = 0;
        }
    }
}