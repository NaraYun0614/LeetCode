class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        // Using ArrayList
        // Check current max candy
        // Check after add extra candies, each kid can reach to max candy or exceed max candy
        // return the ArrayList
        List<Boolean> result = new ArrayList<>();
        int max = 0;

        for (int candy: candies) {
            if (candy > max) {
                max = candy;
            }
        }

        for (int candy: candies) {
            result.add(candy + extraCandies >= max);
        }

        return result;
    }
}