class Solution {
    public int largestAltitude(int[] gain) {
        int maxAltitude = 0;
        int curAltitude = 0;

        for (int g: gain) {
            curAltitude += g;
            maxAltitude = Math.max(curAltitude, maxAltitude);
        }
        return maxAltitude;
    }
}