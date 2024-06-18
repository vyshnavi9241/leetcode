public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> solution = new ArrayList<>();
        dfs(n, k, 1, solution, new ArrayList<Integer>());
        return solution;
    }
    
    private void dfs(int n, int k, int start, List<List<Integer>> l, List<Integer> path) {
        if(k == 0) {
            l.add(path);
            return;
        }
        
        for(int i = start ; i <= n; i++) {
            List<Integer> nPath = new ArrayList<>(path);
            nPath.add(i);
            dfs(n, k - 1, i + 1, l ,nPath);
        }
    }
}

