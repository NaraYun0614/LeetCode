class Solution {
    public String reverseWords(String s) {
        // Trim the string and slit it by spaces using regex
        // Using StringBuilder reverse the words
        String[] words = s.trim().split("\\s+");

        StringBuilder sb = new StringBuilder();

        for (int i = words.length -1; i >= 0; i--) {
            sb.append(words[i]);
            if (i != 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}