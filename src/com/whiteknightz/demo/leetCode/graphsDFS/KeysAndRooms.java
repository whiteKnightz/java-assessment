package com.whiteknightz.demo.leetCode.graphsDFS;

import java.util.*;

/*
    There are n rooms labeled from 0 to n - 1 and all the rooms are locked except for room 0. Your goal is to visit all
    the rooms. However, you cannot enter a locked room without having its key.

    When you visit a room, you may find a set of distinct keys in it. Each key has a number on it, denoting which room
    it unlocks, and you can take all of them with you to unlock the other rooms.

    Given an array rooms where rooms[i] is the set of keys that you can obtain if you visited room i, return true if
    you can visit all the rooms, or false otherwise.
 */
public class KeysAndRooms {
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        List<Boolean> visited = new ArrayList<>(rooms.size());
        Queue<Integer> visitingQueue = new LinkedList<>();
        for (int i = 0; i < rooms.size(); i++) {
            visited.add(Boolean.FALSE);
        }
        visited.add(0, Boolean.TRUE);
        for(int i: rooms.get(0)){
            visitingQueue.offer(i);
        }

        while (!visitingQueue.isEmpty()){
            Integer poll = visitingQueue.poll();
            if (!visited.get(poll)){
                visited.set(poll, Boolean.TRUE);
                for(int i: rooms.get(poll)){
                    visitingQueue.offer(i);
                }
            }
        }

        return visited.stream().filter(aBoolean -> aBoolean==Boolean.TRUE).count()==rooms.size();
    }

    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(Collections.singletonList(1));
        rooms.add(Collections.singletonList(2));
        rooms.add(Collections.singletonList(3));
        rooms.add(Collections.emptyList());

        System.out.println(canVisitAllRooms(rooms));
    }
}
