class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean [] visited = new boolean[rooms.size()];
        dfs(0, rooms, visited);

        for (boolean v : visited) {
            if (!v) return false;   // at least one room is not visited
        }
        return true;    // all rooms visited
    }

    private void dfs(int room, List<List<Integer>> rooms, boolean[] visited) {
        if (visited[room]) return;  // already visited

        visited[room] = true;   // already in the room -> mark as visited

        for (int key : rooms.get(room)){
            dfs(key, rooms, visited);
        }
    }
}