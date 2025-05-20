class Solution {
    public int[] productExceptSelf(int[] nums) {
        // using prefix && suffix
        // prefix = product of all elements to the left of index i
        // suffix = product of all elements to the right of index i

        int len = nums.length;
        int[] output = new int[len];

        // find prefix
        output[0] = 1;
        for (int i = 1; i < len; i++) {
            output[i] = output[i-1] * nums[i-1]; // output = [1, 1, 2, 6]
        }

        // find suffix
        int suffix = 1;
        for (int i = len -1; i >= 0; i--) {
            output[i] = output[i] * suffix; //[24, 12, 8,6]
            suffix *= nums[i];   // suffix = [24, 12, 4, 1]
        }

        return output;  // expect = [24, 12, 8, 6]
    }
}