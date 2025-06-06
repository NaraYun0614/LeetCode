class Solution {
    public String decodeString(String s) {
        // check if c is digit then k = k * 10 + (c-'0') -> build number for repeats
        // if (c = '[') then save current state to stack -> reset k && current state
        // if (c == ']') then pop && build the repeated result

        Stack<String> stack = new Stack<>();
        StringBuilder currStr = new StringBuilder();
        int k = 0;

        for (char c: s.toCharArray()) {
            if (Character.isDigit(c)) {
                k = k * 10 + (c - '0');
            } else if (c == '[') {
                stack.push(currStr.toString());
                stack.push(String.valueOf(k));
                currStr = new StringBuilder();  // reset current String
                k = 0;  // result count
            } else if (c == ']') {
                int count = Integer.parseInt(stack.pop());
                String prev = stack.pop();
                StringBuilder temp = new StringBuilder(prev);

                for (int i = 0; i < count; i++) {
                    temp.append(currStr);
                }
                currStr = temp;
            } else {
                currStr.append(c);
            }
        }
        return currStr.toString();  // because the return type is String
    }
}