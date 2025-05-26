class Solution {
    public int maxOperations(int[] nums, int k) {
        // calculate complement
        // if we find complement then count++
        // if not, store the num
        //using HashMap && getOrDefault() method
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int num: nums) {
            int complement = k - num;
            if (map.getOrDefault(complement, 0) > 0) {
                count++;
                map.put(complement,map.getOrDefault(complement, 0) -1 );
            } else { //store the num in the map
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        return count;
    }
}