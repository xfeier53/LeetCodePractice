//There are N network nodes, labelled 1 to N. 
//
// Given times, a list of travel times as directed edges times[i] = (u, v, w), where u is the source node, v is the target node, and w is the time it takes for a signal to travel from source to target. 
//
// Now, we send a signal from a certain node K. How long will it take for all nodes to receive the signal? If it is impossible, return -1. 
//
// 
//
// Example 1: 
//
// 
//
// 
//Input: times = [[2,1,1],[2,3,1],[3,4,1]], N = 4, K = 2
//Output: 2
// 
//
// 
//
// Note: 
//
// 
// N will be in the range [1, 100]. 
// K will be in the range [1, N]. 
// The length of times will be in the range [1, 6000]. 
// All edges times[i] = (u, v, w) will have 1 <= u, v <= N and 0 <= w <= 100. 
// 
//

class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        int currentPoint = K, min, next = 0, currentDist = 0;
        HashMap<Integer[], Integer> fromToDist = new HashMap<>();
        HashMap<Integer, Integer> temp = new HashMap<>();
        // A map to store every point found and source point and the distance
        HashMap<Integer, Integer[]> toFromDist = new HashMap<>();
        // A map to store the from to shortest distance for now, locked point
        HashMap<Integer, Integer> shortestToDist = new HashMap<>();

        // HashMap store the from to distance value
        for (int i = 0; i < times.length; i++) {
            fromToDist.put(new Integer[] {times[i][0], times[i][1]}, times[i][2]);
        }
        // Temp to iterate, first init to K
        for (Map.Entry<Integer[], Integer> entry : fromToDist.entrySet()) {
            if (entry.getKey()[0] == K) {
                temp.put(entry.getKey()[1], entry.getValue());
            }
        }
        for (int i = 0; i < N; i++) {
            // Init the min
            min = 101;
            // Iterate the temp map to update value for point found and find the minimum to be the next locked point
            for (Map.Entry<Integer, Integer> toDist : temp.entrySet()) {
                // The to point is the source point or has been locked, it is impossible to reach with shorter distance
                if (toDist.getKey() == K || shortestToDist.containsKey(toDist.getKey())) {
                    continue;
                }
                // If the point can be reached before, update its value if the distance from the current point is shorter
                if (toFromDist.containsKey(toDist.getKey())) {
                    if (toFromDist.get(toDist.getKey())[1] > toDist.getValue() + currentDist) {
                        toFromDist.put(toDist.getKey(), new Integer[]{currentPoint, toDist.getValue() + currentDist});
                    } else {
                        continue;
                    }
                    // If the point haven't been reached before, just add it in
                } else {
                    toFromDist.put(toDist.getKey(), new Integer[]{currentPoint, toDist.getValue() + currentDist});
                }
            }
            // If there is no next point, break the loop
            if (toFromDist.isEmpty()) {
                break;
            }
            // Find the minimum of toFromDist to be the next iterate point
            for (Map.Entry<Integer, Integer[]> entry : toFromDist.entrySet()) {
                if (min > entry.getValue()[1]) {
                    next = entry.getKey();
                    min = entry.getValue()[1];
                }
            }
            currentPoint = next;
            currentDist = min;
            // Add the shortest point (locked) in the map
            shortestToDist.put(next, min);
            // Update next iterate point
            temp = new HashMap<>();
            for (Map.Entry<Integer[], Integer> entry : fromToDist.entrySet()) {
                if (entry.getKey()[0] == next) {
                    temp.put(entry.getKey()[1], entry.getValue());
                }
            }
            // No need to store the next point in the toFromDist Map
            toFromDist.remove(next);
        }
        // Find the longest distance in the map
        int max = 0;
        int[] bucket = new int[N];
        bucket[K - 1]++;
        for (Map.Entry<Integer, Integer> entry : shortestToDist.entrySet()) {
            bucket[entry.getKey() - 1]++;
            if (max < entry.getValue()) {
                max = entry.getValue();
            }
        }
        for (int i : bucket) {
            if (i == 0) {
                return -1;
            }
        }
        return max;
    }
}