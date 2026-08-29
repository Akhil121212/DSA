class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] edge : prerequisites) {
            graph.get(edge[1]).add(edge[0]);
        }
        
        int[] state = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0) {
                if (!hasCycle(graph, i, state)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean hasCycle(List<List<Integer>> graph, int node, int[] state) {
        if (state[node] == 1) return false;
        if (state[node] == 2) return true;
        
        state[node] = 1;
        
        for (int neighbor : graph.get(node)) {
            if (!hasCycle(graph, neighbor, state)) {
                return false;
            }
        }
        state[node] = 2;
        return true;
    }
}