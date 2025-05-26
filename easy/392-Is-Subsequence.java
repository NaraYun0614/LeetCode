class Solution {
    public boolean isSubsequence(String s, String t) {
        // use charAt(idx)
        // if its true then i++, if its false then j++;
        // return i == s.length() to check all of the character is included in String t
        int i = 0, j = 0;

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }
}