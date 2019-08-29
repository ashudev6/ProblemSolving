package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GraphTraversals {

    public static void main(String[] ar) {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("breadth first traversal from vertex 2");

        g.bfs(2);

        Graph g1 = new Graph(6);

        g1.addEdge(0, 1);
        g1.addEdge(0, 2);
        g1.addEdge(1,0);
        g1.addEdge(1, 3);
        g1.addEdge(1, 4);
        g1.addEdge(2, 0);
        g1.addEdge(2,4);
        g1.addEdge(3, 2);
        g1.addEdge(3,4);
        g1.addEdge(3,5);
        g1.addEdge(4,1);
        g1.addEdge(4,2);
        g1.addEdge(4,3);
        g1.addEdge(4,5);
        g1.addEdge(5,3);
        g1.addEdge(5,4);

        System.out.println("depth first traversal from vertex 0");

        //g1.DFS(0);

        g1.dfs(0);


    }
}





