package graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.*;

public class Graph {

    int V;
    LinkedList<Integer>[] list;

    Graph(int v) {
        V = v;
        list = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            list[i] = new LinkedList<>();
        }

    }

    void addEdge(int source, int destination) {
        list[source].add(destination);
    }

    void bfs(int source) {
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        visited[source] = true;
        queue.add(source);
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.println("vertex:" + vertex);
            for (Integer i : list[vertex]) {
                if (!visited[i]) queue.add(i);
                visited[i] = true;
            }

        }


    }

    void dfs(int source) {
        boolean[] visited = new boolean[V];
        //Stack<Integer> stack = new Stack<>();
        //dfsUtil(source, visited, stack);
        DFSUtil(source,visited);

    }

    void DFSUtil(int source,boolean[] visited) {
       visited[source] = true;
       System.out.println("vertex: " + source);
       Iterator<Integer> iterator = list[source].listIterator();
       while (iterator.hasNext()) {
           int n = iterator.next();
           if(!visited[n]) DFSUtil(n,visited);
       }
    }

    void dfsUtil(int source, boolean[] visited, Stack<Integer> stack) {
        if (visited[source] && !stack.isEmpty()) {
            stack.pop();
            return;
        }
        visited[source] = true;
        stack.push(source);
        int vertex = stack.peek();
        System.out.println("vertex: " + vertex);
        for (Integer i : list[vertex]) {
            if (!visited[i]) {
                dfsUtil(i, visited, stack);
            }
        }
    }
}



