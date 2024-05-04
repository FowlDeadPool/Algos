
public class mColouring {

    private int[][] graph; 
    private int[] colors; 
    private int n; 
    private int m; 
    private int solutionCount; 


    public mColouring(int[][] graph, int m) {
        this.graph = graph;
        this.n = graph.length;
        this.colors = new int[n];
        this.m = m;
        this.solutionCount = 0;
    }

   
    private void mColoring(int k) {
        do {
            nextValue(k);
            if (colors[k] == 0) 
                return;
            if (k == n - 1) { 
                printSolution();
                solutionCount++; 
            } else
                mColoring(k + 1);
        } while (true);
    }

     void nextValue(int k) {
        do {
            colors[k] = (colors[k] + 1) % (m + 1); 
            if (colors[k] == 0) 
                return;
            int j;
            for (j = 0; j < n; j++) {
                if (graph[k][j] != 0 && colors[k] == colors[j]) 
                    break;
            }
            if (j == n) 
                return;
        } while (true);
    }

    private void printSolution() {
        for (int i = 1; i <= n; i++) {
            System.out.print("Vertex " + (i) + ": Color" + colors[i-1] + " ");
        }
        System.out.println();
    }
    public int getSolutionCount() {
        return solutionCount;
    }


    public static void main(String[] args) {
        int[][] graph = {
            {0, 1, 1, 1, 0, 1},
            {1, 0, 1, 0, 0, 0},
            {1, 1, 0, 1, 0, 0},
            {1, 0, 1, 0, 1, 1},
            {0, 0, 0, 1, 0, 1},
            {1, 0, 0, 1, 1, 0},
        };
        int m = 3; 
        mColouring graphColoring = new mColouring(graph, m);
        graphColoring.mColoring(0);
        System.out.println(graphColoring.solutionCount);

        graph[0][3] = 1;
        graph[3][0] = 1;
      
        m=3;
        mColouring mcolor1 = new mColouring(graph, m);
        mcolor1.mColoring(0);
        System.out.println(mcolor1.solutionCount);

        System.out.println("Solution After Adding the edges 2,4");
        graph[1][3] = 1;
        graph[3][1] = 1;
        m=4;
        mColouring mcolor = new mColouring(graph, m);
        mcolor.mColoring(0);
        System.out.println(mcolor.solutionCount);
    }
}

