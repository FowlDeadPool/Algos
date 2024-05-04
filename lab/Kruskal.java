//weight of the graph is alphabets

import java.util.ArrayList;

import java.util.Comparator;
import java.util.List;

public class Kruskal {
    static class Edge {
        int src, dest;
        char weight;

        // Making a class Edge to define the edges
        public Edge(int src, int dest, char weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    static class subset {
        int parent, rank;

        public subset(int parent, int rank) {
            this.parent = parent;
            this.rank = rank;
        }
    }

    static List<Kruskal.Edge> kruskal(int V, List<Edge> graphEdges) {
        // sort edges ascending order
        graphEdges.sort(new Comparator<Edge>() {
            public int compare(Edge e1, Edge e2) {
                return Character.compare(e1.weight, e2.weight);
            }
        });
        
        System.out.println("Sorted Edges");
        for (Edge edge : graphEdges) {
            System.out.println(edge.src + " - " + edge.dest + " : " + edge.weight);
        }
        subset[] subsets = new subset[V];
        for (int v = 0; v < V; v++) {
            subsets[v] = new subset(v, 0);
        }
        // new arraylist to store mst
        List<Edge> mst = new ArrayList<>();

        int i = 0;
        while (mst.size() < V - 1) {
            Edge ed = graphEdges.get(i++);

            int v1 = find(subsets, ed.src - 1);
            int v2 = find(subsets, ed.dest - 1);

            if (v1 != v2) {
                mst.add(ed);
                Union(subsets, v1, v2);
            }
        }
        return mst;
    }

    static int find(subset subsets[], int i) {
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);

        return subsets[i].parent;
    }

    static void Union(subset subsets[], int v1, int v2) {
        int xroot = find(subsets, v1);
        int yroot = find(subsets, v2);

        if (subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank > subsets[yroot].rank)
            subsets[yroot].parent = xroot;

        else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }

    public static void main(String[] args) {
        int Vertex = 6;
        List<Edge> graphEdges = new ArrayList<>(
                List.of(new Edge(1, 2, 'b'),
                        new Edge(1, 6, 'g'),
                        new Edge(2, 6, 'a'),
                        new Edge(2, 3, 'd'),
                        new Edge(6, 5, 'c'),
                        new Edge(5, 4, 'b'),
                        new Edge(5, 3, 'f'),
                        new Edge(3, 4, 'e')));

        List<Edge> mst = kruskal(Vertex, graphEdges);
        System.out.println("Minimum Spanning Tree:");
        for (Edge edge : mst) {
            System.out.println(edge.src + " - " + edge.dest + " : " + edge.weight);
        }

    }
}
