class Solution {
    public int equalPairs(int[][] grid) {
        // store each row into a map as string
        // if rowMap contains column then count++;
        int n = grid.length;
        Map <String, Integer> rowMap = new HashMap<>();
        int count = 0;

        for (int i = 0; i < n; i++) {
            String rowKey = Arrays.toString(grid[i]);
            rowMap.put(rowKey, rowMap.getOrDefault(rowKey, 0) + 1);
        }
        // check column && compare it with row
        for (int j = 0; j < n; j++) {
            int[] col = new int[n];
            for (int i = 0; i < n; i++) {
                col[i] = grid[i][j];
            }
            String colKey = Arrays.toString(col);
            count += rowMap.getOrDefault(colKey, 0);
        }
        return count;
    }
}