package graphs;
import java.util.*;

//https://leetcode.com/problems/keys-and-rooms
public class CanVisitAllRooms {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> set = new HashSet<>();
        if (rooms.size() > 0) {
            int source = 0;
            Queue<Integer> queue = new LinkedList<>();
            set.add(0);
            queue.add(0);
            while(!queue.isEmpty()) {
                int room = queue.poll();
                for (Integer i : rooms.get(room)) {
                    if (!set.contains(i))  {
                        queue.add(i);
                        set.add(i);
                    }
                }
            }
        }
        return set.size() == rooms.size();



    }
}
