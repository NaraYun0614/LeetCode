class Solution {
    public int minReorder(int n, int[][] connections) {
        // build a graph with both directions marked
        // use dfs to visit all cities
        // count how many edges go the wrong directions
        Map <Integer, List<int[]>> graph = new HashMap<>();

        for (int[] conn: connections) {
            int from = conn[0], to = conn[1];

            // add both directions and mark it with 0 or 1
            // 1 is original direction (need reversing if we go this way)
            graph.computeIfAbsent(from, x -> new ArrayList<>()).add(new int[]{to, 1});
            graph.computeIfAbsent(to, x -> new ArrayList<>()).add(new int[]{from, 0});
        }

        boolean[] visited = new boolean[n];

        return dfs(0, graph, visited);
    }

    private int dfs(int city, Map<Integer, List<int[]>> graph, boolean[] visited) {
        visited[city] = true;
        int count = 0;

        for (int[] neighbor: graph.getOrDefault(city, new ArrayList<>())) {
            int next = neighbor[0];
            int needToReverse = neighbor[1];

            if (!visited[next]) {
                count += needToReverse + dfs(next, graph, visited);
            }
        }

        return count;
    }
}