class Solution {
    public String removeStars(String s) {
        // Using stack && StringBuilder
        // s.toCharArray()
        // if c == "*" -> stack.pop() else stack.push(c)
        Stack<Character> stack = new Stack<>();

        for (char c: s.toCharArray()) {
            if (c == '*') {
                stack.pop(); // remove the last character
            } else {
                stack.push(c); // add the character to the stack
            }
        }

        StringBuilder result = new StringBuilder();
        for (char c: stack) {
            result.append(c);
        }
        return result.toString();
    }
}