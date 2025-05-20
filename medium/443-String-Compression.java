class Solution {
    public int compress(char[] chars) {
        // if current char is same as previous char, count++;
        // or if i == chars.length, we are at the end

        int write = 0;
        int count = 1;

        for (int i = 1; i <= chars.length; i++) {
            if (i < chars.length && chars[i] == chars[i-1]) {
                count++;
            } else {
                chars[write++] = chars[i-1];

                if (count > 1) {
                    for (char c: Integer.toString(count).toCharArray()) {
                        chars[write++] = c;
                    }
                }
                count = 1;
            }
        }
        return write;

    }
}