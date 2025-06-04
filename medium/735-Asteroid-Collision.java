class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        // use boolean destroyed variable
        // using while loop and check the size of left astroid && right asteroid.
        // to explodes always left > 0, right < 0
        Stack<Integer> stack = new Stack<>();
        for (int asteroid: asteroids) {
            boolean destoyed = false;   // reset for current iteration

            while(!stack.isEmpty() && stack.peek() > 0 && asteroid < 0) { // left should be +, right should be + to have collision
                int top = stack.peek();
                if (top < -asteroid) {
                    stack.pop(); // top explodes && keep checking
                } else if (top == -asteroid) { // both explode
                    stack.pop();
                    destoyed = true;
                    break;
                } else {    // only asteroid explodes
                    destoyed = true;
                    break;
                }
            }
            if (!destoyed) {
                stack.push(asteroid);
            }
        }

        // convert to array
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();    // because stack is LIFO
        }
        return result;
    }
}