import java.util.*;

public class Lab6 {
    public static void main(String[] args) {
        int[][] test1 = {{1,0}};
        System.out.println(canFinish(2, test1));
        int[][] test2 = {{1,0}, {0, 1}};
        System.out.println(canFinish(2, test2));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) { // Function Header
        // Find the 0 indegree nodes
        // Put them in a queue

        int[] indegree = new int[numCourses]; // make a array to store indegrees
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(); // make an adjacency list

        for (int i = 0; i < numCourses; i++) { // a for loop to fill adj with arraylists
            adj.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) { // fill indegree and put in adj
            indegree[pre[0]]++;
            adj.get(pre[1]).add(pre[0]);
        }

        Queue<Integer> q = new LinkedList<>(); //make a queue
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        // Now the 0 indegree nodes have been found and added to the queue

        // make a number that counts all the removed nodes
        int num = 0;
        // While the queue is not empty
        while (!q.isEmpty()) {
            //Remove a node from the queue.
            int current = q.remove();
            num++; // incrementing
            // For each outgoing edge from the node, decrement the
            // in-degree of the destination node by 1.
            for (int i : adj.get(current)) {
                indegree[i]--;

                // If the in-degree of a destination node becomes 0, add it to the queue
                if (indegree[i] == 0) {
                    q.add(i);
                }
            }
        }
        return num == numCourses;
    }
}
