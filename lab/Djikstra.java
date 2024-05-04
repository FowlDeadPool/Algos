public class Djikstra {

    static void shortestPath(int[] dist, boolean visited[], int Graph[][]) {

        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
            dist[i] = Integer.MAX_VALUE;
        }
        dist[0] = 0;

        for (int count = 0; count < visited.length - 1; count++) {
            int u = minDistance(dist, visited);
            visited[u] = true;

            for (int v = 0; v < Graph.length; v++) {
                if (!visited[v] && Graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE &&
                        dist[v] > dist[u] + Graph[u][v]) {
                    dist[v] = dist[u] + Graph[u][v];
                }
            }
        }
    }

    static int minDistance(int[] dist, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int v = 0; v < dist.length; v++) {
            if (!visited[v] && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    public static void main(String[] args) {
        int V = 6;
        int Graph[][] = new int[][]{{0, 3, 4, 0, 0, 0},
                                    {3, 0, 1, 0, 0, 6},
                                    {4, 1, 0, 3, 0, 6},
                                    {0, 0, 3, 0, 2, 4},
                                    {0, 0, 0, 2, 0, 3},
                                    {0, 6, 6, 4, 3, 0}
        };

        int[] dist = new int[V];
        boolean[] visited = new boolean[V];
        shortestPath(dist, visited, Graph);

      
        for (int i = 0; i < V; i++) {
            System.out.println("Distance from node 0 to node " + i + " is: " + dist[i]);
        }
    }
}
