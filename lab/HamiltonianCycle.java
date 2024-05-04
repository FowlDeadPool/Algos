public class HamiltonianCycle {

    private int[][] G;
    private int[] x;
    private int n;
    private int solutionCount; 

    public HamiltonianCycle(int[][] graph) {
        this.G = graph;
        this.n = graph.length;
        this.x = new int[n];
        this.solutionCount = 0;

        for (int i = 0; i < n; i++) {
            x[i] = -1;
        }
    }

    void hamiltonian(int k) {
        if (k == n) {
            if (G[x[n - 1]][x[0]] != 0) {
                printSolution();
                solutionCount++; 
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isValid(i, k)) {
                x[k] = i;
                hamiltonian(k + 1);
                x[k] = -1;
            }
        }
    }

    boolean isValid(int v, int k) {
        if (G[x[k - 1]][v] == 0) {
            return false;
        }
        for (int j = 0; j < k; j++) {
            if (x[j] == v) {
                return false;
            }
        }
        return true;
    }

    private void printSolution() {
        for (int i = 0; i < n; i++) {
            System.out.print(x[i] + " ");
        }
        System.out.print(x[0]);
        System.out.println();
    }
    public int getSolutionCount() {
        return solutionCount;
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 1, 1, 1, 0, 0},
                {1, 0, 1, 0, 1, 0},
                {1, 1, 0, 1, 1, 0},
                {1, 0, 1, 0, 1, 1},
                {0, 1, 1, 1, 0, 1},
                {0, 0, 0, 1, 1, 0}
        };
        HamiltonianCycle hc = new HamiltonianCycle(graph);
        hc.x[0] = 0; 
        hc.hamiltonian(1); 
        System.out.println(hc.solutionCount);
    }
}
