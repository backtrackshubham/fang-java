package shubham.edu.dsalgo.leet.code.practice;

import java.util.*;

/**
 * There are N rooms and you start in room 0.  Each room has a distinct number in 0, 1, 2, ..., N-1, and each room may have some keys to access the next room.
 *
 * Formally, each room i has a list of keys rooms[i], and each key rooms[i][j] is an integer in [0, 1, ..., N-1] where N = rooms.length.  A key rooms[i][j] = v opens the room with number v.
 *
 * Initially, all the rooms start locked (except for room 0).
 *
 * You can walk back and forth between rooms freely.
 *
 * Return true if and only if you can enter every room.
 */
public class RoomVisit {
    public static void main(String[] args) {

    }
}

class RoomVisitSolution {
    static public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Boolean[] resultRetriever = new Boolean[rooms.size()];
        Arrays.fill(resultRetriever, false);

        Set<Integer> toVisit = new HashSet<>();
        toVisit.add(0);
        while (!toVisit.isEmpty()) {
            Iterator<Integer> li = toVisit.iterator();
            Set<Integer> newListToVist = new HashSet<>();
            while (li.hasNext()) {
                Integer visited = li.next();
                if(!resultRetriever[visited]){
                    resultRetriever[visited] = true;
                    newListToVist.addAll(rooms.get(visited));
                }
            }
            toVisit = newListToVist;
        }

        // Creating list of integers
        List<Integer> array = Arrays.asList(-2, 0, 4, 6, 8);

        // Finding sum of all elements
        int sum = array.stream().reduce(0, Integer::sum);


        List<Boolean> booleans = Arrays.asList(resultRetriever);
        return booleans.stream().reduce(true, (a,b) -> a & b);

    }

    private static boolean[] visit(int room, List<Integer> roomKeys, boolean[] toUpdate){
        if (toUpdate[room]){//room already visited
            return toUpdate;
        } else {
            ListIterator<Integer> li = roomKeys.listIterator();
            while (li.hasNext()){
                toUpdate[li.next()] = true;
            }
            return toUpdate;
        }
    }
}
