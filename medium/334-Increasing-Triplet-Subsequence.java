class Solution {
    public boolean increasingTriplet(int[] nums) {
        // No need to be sequenced

        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int n: nums) {
            if (n <= first) {
                first = n;
            } else if (n <= second) {
                second = n;
            } else {
                return true; // find third number which is greater then first && second
            }
        }
        return false;
    }
}