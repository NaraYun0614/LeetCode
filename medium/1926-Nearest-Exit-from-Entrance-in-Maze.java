class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int rows = maze.length;
        int cols = maze[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{entrance[0], entrance[1], 0});    // row & column & distance
        maze[entrance[0]] [entrance[1]] = '+';

        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};    // right, down, up, left

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0], col = curr[1], distance = curr[2];

            for (int[] dir: directions) {   // check all directions
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                // 범위 확인 및 통로 확인
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && maze[newRow][newCol] == '.') {

                    // check for exit
                    if (newRow == 0 || newCol == 0 || newRow == rows - 1 || newCol == cols - 1) {
                        return distance + 1;
                    }

                    // couldn't find the exit yet but there is still a way to move
                    queue.offer(new int[]{newRow, newCol, distance + 1});
                    maze[newRow][newCol] = '+';
                }
            }
        }
        return -1;
    }
}