public class TSP {
    static final int START_NODE = 0;
    public static int[][] adjMat = {
            { 0, 3, 6, 8 },
            { 3, 0, 9, 4 },
            { 6, 9, 0, 2 },
            { 8, 4, 2, 0 }
    };
    public static int cost = Integer.MAX_VALUE;
    public static int[] visited = new int[adjMat.length];

    private boolean allVisited(int[] visited, int curNode) {
        for (int i = 0; i < visited.length; i++) {
            if (i != curNode && visited[i] == -1)
                return false;
        }
        return true;
    }

    public void tsp(int[][] graph, int[] visited, int curNode, int curCost) {
        for (int i = 0; i < graph.length; i++) {
            if (graph[curNode][i] != 0 && visited[i] == -1) {
                visited[curNode] = i;
                tsp(graph, visited, i, curCost + graph[curNode][i]);
                visited[curNode] = -1;
            }
        }
        if (allVisited(visited, curNode)) {
            if (graph[curNode][START_NODE] != 0) {
                cost = Math.min(curCost + graph[curNode][START_NODE], cost);
                printPath(visited);
                System.out.println("Cost: " + (curCost + graph[curNode][START_NODE]));
            }
        }
    }

    public void printPath(int[] visited) {
        System.out.print(0 + "->");
        int i = 0;
        while (visited[i] != -1) {
            System.out.print(visited[i] + "->");
            i = visited[i];
        }
        System.out.print(0 + " ");
    }

    public static void printArr(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TSP t = new TSP();
        for (int i = 0; i < visited.length; i++) {
            visited[i] = -1;
        }
        t.tsp(adjMat, visited, START_NODE, 0);
        System.out.println(cost);
    }
}
