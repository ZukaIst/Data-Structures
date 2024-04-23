import java.util.ArrayList;
import java.util.Arrays;

public class JavaHw12 {

    public static void main(String[] args) {
        // Test Case 1: Given test case
        int[] wells1 = {1,1};
        int[][] pipes1 = {{1,2,1},
                          {1,2,2}};
        System.out.println(minCostToSupplyWater(2, wells1, pipes1)); // 2 output

        // Test Case 3: Pipe is cheaper
        int[] wells2 = {10, 20, 30};
        int[][] pipes2 = {{1, 2, 5},
                          {2, 3, 5},
                          {1, 3, 20}};
        System.out.println(minCostToSupplyWater(3, wells2, pipes2)); // 20 output

        // Test Case 4: Cheap pipe tiebreak
        int[] wells3 = {50, 50, 50, 50};
        int[][] pipes3 = {{1, 2, 10},
                          {2, 3, 10},
                          {3, 4, 10},
                          {1, 3, 30}};
        System.out.println(minCostToSupplyWater(4, wells3, pipes3)); // 80 output
    }

    public static int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        ArrayList <int[]> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            edges.add(new int[] {0, i + 1, wells[i]});
        }

        // IntelliJ recommended instead of for loop
        edges.addAll(Arrays.asList(pipes));

        // we use quickSort in order to sort the information
        int[][] arrayOfEdges = edges.toArray(new int[0][]);
        quickSort(arrayOfEdges, 0, arrayOfEdges.length - 1);

        //create minimum spanning tree
        int[] minTree = new int[n+1];
        for (int i = 0; i <= n; i++) {
            minTree[i] = i;
        }

        //create a counter and the cost
        int count = 0, cost = 0;
        //for all the edges on the edge list
        for (int[] edge : arrayOfEdges) {
            if (find(minTree, edge[0]) != find(minTree, edge[1])) { //if the edge doesn't create a cycle
                union(minTree, edge[0], edge[1]); // add it to the minimum spanning tree
                // increment count and cost
                cost += edge[2];
                count += 1;
                if (count == n) { //if we've added all of the houses to the MST finish
                    break;
                }
            }
        }
        return cost; //return the cost
    }

    private static void quickSort(int[][] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    // Partition function for quicksort
    private static int partition(int[][] array, int low, int high) {
        int pivot = array[high][2];  // Take the last element as pivot
        int i = low - 1;  // Index of smaller element

        for (int j = low; j < high; j++) {
            // If current element is smaller than the pivot
            if (array[j][2] < pivot) {
                i++;

                // Swap array[i] and array[j]
                int[] temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // Swap array[i+1] and array[high] (or pivot)
        int[] temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    // Find for finding the set of the node 'i'
    private static int find(int[] parent, int i) {
        if (parent[i] != i) {
            parent[i] = find(parent, parent[i]);
        }
        return parent[i];
    }

    // Union for adding an edge to the MST
    private static void union(int[] parent, int i, int j) {
        int rootI = find(parent, i);
        int rootJ = find(parent, j);
        if (rootI != rootJ) {
            parent[rootI] = rootJ;
        }
    }
}
