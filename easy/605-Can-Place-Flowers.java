class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // Check current, left, right
        // left is possible to 0 or i -1
        // right is possible to 0 or flowerbed.length() -1
        // if current is not 1 && left && right is not 1 then plant -> flowerbed[i] = 1
        // i++ increment the plant count (n)
        // check if count>= n then true
        // Time Complexity: O(n): Since we need to go over the flowerbed array
        int count = 0;
        int length = flowerbed.length;

        for (int i = 0; i < length; i++) {
            if (flowerbed[i] == 0 &&
                    (i == 0 || flowerbed[i-1] == 0) &&
                    ((i == length-1) || flowerbed[i+1] == 0)) {
                flowerbed[i] = 1;
                count++;

                if (count>= n) {
                    return true;
                }
            }
        }
        return (count>=n);
    }
}