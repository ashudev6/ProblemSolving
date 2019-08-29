package graphs;

import java.util.*;

public class ReachableNodes {

    public static void main (String[] ar) {
      Graph g = new Graph(7);
      g.addEdge(0,1);
      g.addEdge(1,3);
      g.addEdge(3,2);
      g.addEdge(2,0);
      g.addEdge(4,5);
      g.addEdge(5,6);
      g.addEdge(6,4);

      Set<Integer> s = new HashSet<>();
      List<Integer> l;
      s= getSet();
      Set<Integer> s1 []  =  new HashSet[2];


      Map<Integer,Boolean> map;
      //map.a
      //s.s
        //l.s


      int[] arr = {0,1,4};
        for (int i = 0; i < arr.length; i++) {
            System.out.println("reachable nodes from" + arr[i] + " are: ");
            g.dfs(arr[i]);
        }



    }

    static  Set<Integer> getSet () {
        return new HashSet<>();
    }
}
