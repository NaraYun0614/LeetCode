class Solution {
    public int pivotIndex(int[] nums) {
        // use totalSum(= sum of all elements) && leftSum (totalSum - leftSum - nums[i])
        // no such idx exist -> return -1
        int totalSum = 0;
        for (int num: nums) {
            totalSum += num;
        }

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            // check if leftSum == rightSum
            if (leftSum == totalSum - leftSum - nums[i]) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}