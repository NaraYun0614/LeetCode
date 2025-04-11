class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map <Integer,Integer> numToIdx = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int need = target - current;
            if (numToIdx.containsKey(need)) {
                return new int [] {numToIdx.get(need), i};
            }
            numToIdx.put(current,i);
        }
        return null;
    }
}