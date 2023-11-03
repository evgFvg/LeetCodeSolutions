
/*841. Keys and Rooms
Medium
5.8K
253
Companies
There are n rooms labeled from 0 to n - 1 and all the rooms are locked except for room 0. Your goal is to visit all the rooms. However, you cannot enter a locked room without having its key.

When you visit a room, you may find a set of distinct keys in it. Each key has a number on it, denoting which room it unlocks, and you can take all of them with you to unlock the other rooms.

Given an array rooms where rooms[i] is the set of keys that you can obtain if you visited room i, return true if you can visit all the rooms, or false otherwise.



Example 1:

Input: rooms = [[1],[2],[3],[]]
Output: true
Explanation:
We visit room 0 and pick up key 1.
We then visit room 1 and pick up key 2.
We then visit room 2 and pick up key 3.
We then visit room 3.
Since we were able to visit every room, we return true.
Example 2:

Input: rooms = [[1,3],[3,0,1],[2],[0]]
Output: false
Explanation: We can not enter room number 2 since the only key that unlocks it is in that room.*/


import java.util.*;

public class Solution841_RoomsAndKeys {
    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        List<Integer> list1 = List.of(1, 3);
        List<Integer> list2 = List.of(3, 0, 1);
        List<Integer> list3 = List.of(2);
        List<Integer> list4 = List.of(0);
        rooms.add(list1);
        rooms.add(list2);
        rooms.add(list3);
        rooms.add(list4);
        Solution841_RoomsAndKeys s = new Solution841_RoomsAndKeys();

        System.out.println(s.canVisitAllRooms(rooms));


    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        visited[0] = true;

        Queue<Integer> q = new LinkedList<>();
        q.addAll(rooms.get(0));

        while (!q.isEmpty()) {
            int room = q.poll();
            if (!visited[room]) {
                visited[room] = true;
                q.addAll(rooms.get(room));
            }
        }

        for (boolean b : visited) {
            if (!b) {
                return false;
            }
        }

        return true;

    }
}
