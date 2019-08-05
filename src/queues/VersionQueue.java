package queues;

import java.util.*;

public class VersionQueue {

    static  Map<Integer, HashMap<Character,Integer>> map = new TreeMap<>();

    public static void main(String[] ar) {
        storeOperations(1,'E',1);
        storeOperations(2,'E',2);
        storeOperations(3,'E',3);
        storeOperations(4,'D',0);
        storeOperations(5,'D',0);
        System.out.println(map);
        printVersionQueue(5);

    }

    static  void storeOperations (Integer opCode,Character op,int val) {
        HashMap<Character,Integer> mapVal = new HashMap<>();
        mapVal.put(op,val);
        map.put(opCode,mapVal);
    }

    static void printVersionQueue(Integer opCode) {
        Queue<Integer> queue = new LinkedList();
        for (Map.Entry<Integer, HashMap<Character,Integer>> e: map.entrySet()) {
             if (e.getKey() <= opCode) {
                 if (e.getValue().containsKey('E')) {
                     queue.add(e.getValue().get('E'));
                 } else {
                     queue.poll();
                 }
             }else {
                 break;
             }
        }
        System.out.println(queue);
    }


}
