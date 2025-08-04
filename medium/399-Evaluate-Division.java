class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);

            double value = values[i];

            graph.computeIfAbsent(a, x -> new HashMap<>()).put(b, value);
            graph.computeIfAbsent(b, x -> new HashMap<>()).put(a, 1.0/value);
        }

        // process queries
        double[] result = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);

            Set<String> visited = new HashSet<>();
            result[i] = dfs(start, end, 1.0, visited, graph);
        }
        return result;
    }

    private double dfs(String current, String target, double product, Set<String> visited, Map<String, Map<String, Double>> graph) {
        if (!graph.containsKey(current)) return -1.0;
        if (current.equals(target)) return product;

        visited.add(current);

        for (Map.Entry<String, Double> neighbor: graph.get(current).entrySet()) {
            if (!visited.contains(neighbor.getKey())) {
                double res = dfs(neighbor.getKey(), target, product * neighbor.getValue(), visited, graph);
                if (res != -1.0) return res;
            }
        }
        return -1.0;
    }
}