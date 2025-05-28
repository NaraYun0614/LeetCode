class Solution {
    public int longestOnes(int[] nums, int k) {
        // using left && right -> sliding windows
        // if zeros > k then left++
        // count the length right - left + 1
        int left = 0, zeros = 0, max = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeros++;
            }
            while (zeros > k) {
                if (nums[left] == 0) {
                    zeros--;
                }
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}