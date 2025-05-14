class Solution {
    public String mergeAlternately(String word1, String word2) {
        // Using StringBuilder()
        // word1의 current idx가 word1의 길이보다 짧거나
        // word2의 current idx가 word2의 길이보다 짧으면
        // merged string에 current idx append 하고 1을 더함
        StringBuilder merged = new StringBuilder();
        int i = 0, j = 0;
        int n = word1.length(), m = word2.length();

        while (i < n || j < m) {
            if (i < n) {
                merged.append(word1.charAt(i++));
            }
            if (j < m) {
                merged.append(word2.charAt(j++));
            }
        }
        return merged.toString();
    }
}