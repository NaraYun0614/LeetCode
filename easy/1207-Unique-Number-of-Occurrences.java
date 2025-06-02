class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        // Should use HashMap
        // update the frequency of n with freqMap.getOrDefault(n, 0) + 1
        // and HashSet to check duplication of count -> if there is duplicates return false else true
        Map<Integer,Integer> freqMap = new HashMap<>();

        for (int n: arr) {
            freqMap.put(n, freqMap.getOrDefault(n, 0) + 1);
        }

        Set<Integer> occurrences = new HashSet<>();

        for (int count: freqMap.values()) {
            if(!occurrences.add(count)) { // duplicate count found
                return false;
            }
        }
        return true;
    }
}