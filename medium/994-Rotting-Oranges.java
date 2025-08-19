class Solution {
    public int orangesRotting(int[][] grid) {
        // put all the rotten oranges into Queue and expand using BFS
        // time increases in units of levels
        // check if all oranges have been rotted
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;

        // 1: count fresh oranges & add rotten oranges into Queue
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    queue.offer(new int[]{r, c});
                } else if (grid[r][c] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) return 0;   // no fresh orange exists from begin

        int minutes = -1;
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};    // down, right, up, left

        // 2: BFS traversal
        while (!queue.isEmpty()) {
            int size = queue.size();
            minutes++;

            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int row = cell[0], col = cell[1];

                // check 4 directions
                for (int[] dir: directions) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    // found fresh orange
                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;
                        queue.offer(new int[]{newRow, newCol});
                        fresh--;
                    }
                }
            }
        }
        return fresh == 0 ? minutes : -1;
    }
}