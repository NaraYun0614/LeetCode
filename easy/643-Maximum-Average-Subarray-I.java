class Solution {
    public double findMaxAverage(int[] nums, int k) {
        // using sliding window
        // get the sum of the first window of size k
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int maxSum = sum;
        // slide the window from left to right
        for (int i = k; i < nums.length; i++) {
            sum = sum - nums[i-k] + nums[i];
            maxSum = Math.max(maxSum, sum);
        }
        return (double) maxSum / k;
    }
}