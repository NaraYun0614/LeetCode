class Solution {
    public int findCircleNum(int[][] isConnected) {
        // 1. create visited array to mark cities we've already checked
        // 2. loop over each city and if it is not visited -> dfs, and province++
        // 3. In dfs, visit curr city, recursively visit all connected and not visited neighbor cities

        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, i);
                provinces++;
            }
        }
        return provinces;
    }

    private void dfs(int[][] isConnected, boolean[] visited, int city) {
        visited[city] = true;

        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[city][j] == 1 && !visited[j]) {
                dfs(isConnected, visited, j);
            }
        }
    }
}