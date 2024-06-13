class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        int[] indegree = new int[numCourses];

        // Initialize adjacency list
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        // Build adjacency list and calculate indegree
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prereq = prerequisite[1];
            adjList.get(prereq).add(course);
            indegree[course]++;
        }

        // Perform topological sorting using Kahn's algorithm
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int current = queue.poll();
            result.add(current);

            for (int next : adjList.get(current)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        // Check if all courses can be taken
        if (result.size() != numCourses) {
            return new int[0]; // Impossible to finish all courses
        }

        // Convert result list to array
        int[] courseOrder = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            courseOrder[i] = result.get(i);
        }

        return courseOrder;
    
    }
}