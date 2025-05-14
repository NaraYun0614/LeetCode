class Solution {
    public String reverseVowels(String s) {
        // s.toCharArray()
        // Using 2 pointers (1 left, 1 right)
        // while left < right, move left && right and check char is Vowel or not
        // Char == vowel -> Swap , !char == vowel move to next
        // return String
        // need private method to finding vowel

        char[] chars = s.toCharArray();
        int left = 0, right = chars.length -1;

        while (left < right) {
            while (left < right && !isVowel(chars[left])) {
                left++;
            }
            while (left< right && !isVowel(chars[right])) {
                right--;
            }

            // Swap vowels
            char tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;

            left++;
            right--;

        }
        return new String(chars);
    }
    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}