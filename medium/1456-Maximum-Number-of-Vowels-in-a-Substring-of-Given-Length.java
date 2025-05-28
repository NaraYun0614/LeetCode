class Solution {
    public int maxVowels(String s, int k) {
        int numOfVowels = 0;
        // get the numOfVowels of the first window of size k
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i)) == 1) {
                numOfVowels++;
            }
        }
        int maxNumOfVowels = numOfVowels;
        for (int i = k; i < s.length(); i++) {
            numOfVowels = numOfVowels - isVowel(s.charAt(i-k)) + isVowel(s.charAt(i));
            maxNumOfVowels = Math.max(maxNumOfVowels, numOfVowels);
        }
        return maxNumOfVowels;
    }
    private int isVowel(char c) {
        if ("aeiou".indexOf(c) != -1) {
            return 1;
        } else return 0;
    }
}