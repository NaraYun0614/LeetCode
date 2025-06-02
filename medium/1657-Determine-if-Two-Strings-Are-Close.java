class Solution {
    public boolean closeStrings(String word1, String word2) {
        // changing words to char -> .toCharArray()
        // count the character frequencies using HashMap
        // ensure both string uses same characters -> keySet().equals
        // ensure both have same counts, regardless of which char
        // making a list of vaules of both strings && sort it
        // compare it
        if (word1.length() != word2.length()) return false;

        Map<Character, Integer> freq1 = new HashMap<>();
        Map<Character, Integer> freq2 = new HashMap<>();

        for (char c: word1.toCharArray()) {
            freq1.put(c, freq1.getOrDefault(c, 0) + 1);
        }
        for (char c: word2.toCharArray()) {
            freq2.put(c, freq2.getOrDefault(c, 0) + 1);
        }
        // check if they have same characters
        if (!freq1.keySet().equals(freq2.keySet())) return false;

        List<Integer> values1 = new ArrayList<>(freq1.values());
        List<Integer> values2 = new ArrayList<>(freq2.values());

        Collections.sort(values1);
        Collections.sort(values2);

        return values1.equals(values2);
    }
}