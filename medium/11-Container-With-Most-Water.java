class Solution {
    public int maxArea(int[] height) {
        // Check max size of container using Math function
        // h * W & compare with max
        int max = 0;
        int left = 0, right = height.length - 1;

        while (left < right) {
            int h = Math.min(height[left], height[right]);
            int w = right - left;
            max = Math.max(max, h * w);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}