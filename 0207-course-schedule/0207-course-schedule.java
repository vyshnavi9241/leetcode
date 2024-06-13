import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            adjList.get(prerequisite[1]).add(prerequisite[0]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] recursionStack = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i] && isCyclic(i, adjList, visited, recursionStack)) {
                return false;
            }
        }

        return true;
    }

    private boolean isCyclic(int course, List<List<Integer>> adjList, boolean[] visited, boolean[] recursionStack) {
        if (recursionStack[course]) {
            return true;
        }

        if (visited[course]) {
            return false;
        }

        visited[course] = true;
        recursionStack[course] = true;

        for (int nextCourse : adjList.get(course)) {
            if (isCyclic(nextCourse, adjList, visited, recursionStack)) {
                return true;
            }
        }

        recursionStack[course] = false;
        return false;
    }
}