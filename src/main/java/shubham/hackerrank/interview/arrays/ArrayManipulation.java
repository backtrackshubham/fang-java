package shubham.hackerrank.interview.arrays;


/**
 * Starting with a 1-indexed array of zeros and a list of operations, for each operation add a value to each the array element between two given indices, inclusive. Once all operations have been performed, return the maximum value in the array.
 * <p>
 * Example
 * n = 10
 * quries | |1 ,5, 3|, |4, 8, 7|, |6, 9, 1| |
 * <p>
 * Queries are interpreted as follows:
 * <p>
 * a b k
 * 1 5 3
 * 4 8 7
 * 6 9 1
 * Add the values of  between the indices  and  inclusive:
 * <p>
 * index->	 1 2 3  4  5 6 7 8 9  10
 * [0,0,0, 0, 0,0,0,0,0, 0 ]
 * [3,3,3, 3, 3,0,0,0,0, 0 ]
 * [3,3,3,10,10,7,7,7,0, 0 ]
 * [3,3,3,10,10,8,8,8,1, 0 ]
 * The largest value is 10  after all operations are performed.
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ArrayManipulation {
    public static long arrayManipulation2(int n, List<List<Integer>> queries) {
        Map<String, Long> map = new HashMap<>();
        for (List<Integer> query : queries) {
            map = updateMapWithOverLaps(map, query);
        }

        Long maxValue = Long.MIN_VALUE;
        for (String key : map.keySet()) {
            Long exVal = map.get(key);
            if (exVal > maxValue)
                maxValue = exVal;
        }

        return maxValue;
    }

    private static Map<String, Long> updateMapWithOverLaps(Map<String, Long> map, List<Integer> query) {
        Set<String> keysWithOverLap = map
                .keySet()
                .stream()
                .filter(key -> hasOverlap(key, query.get(0), query.get(1)))
                .collect(Collectors.toSet());

        if (!keysWithOverLap.isEmpty()) {
            for (String key : keysWithOverLap) {
                map = updateMapForKey(map, key, query);
            }
        } else {
            map.put(query.get(0) + "-" + query.get(1), Long.parseLong(query.get(2).toString()));
        }

        return map;
    }

    private static Map<String, Long> updateMapForKey(Map<String, Long> map, String key, List<Integer> queryWithOverlap) {
        String[] split = key.split("-");
        Long keyValue = map.get(key);
        Integer keyStart = Integer.parseInt(split[0]);
        Integer keyEnd = Integer.parseInt(split[1]);
        Integer queryStart = queryWithOverlap.get(0);
        Integer queryEnd = queryWithOverlap.get(1);
        Integer queryValue = queryWithOverlap.get(2);

        Integer startPos = keyStart < queryStart ? keyStart : queryStart;
        Integer endPos = keyEnd > queryEnd ? keyEnd : queryEnd;

        //tobe completed
        return map;

    }

    private static boolean hasOverlap(String key, Integer newStart, Integer newEnd) {
        String[] arr = key.split("-");
        Integer oldStart = Integer.parseInt(arr[0]);
        Integer oldEnd = Integer.parseInt(arr[1]);
        return !(newStart > oldEnd || newEnd < oldStart);
    }

    static long arrayManipulation(int n, List<List<Integer>> queries){
        long[] arr = new long[n + 1];
        for (List<Integer> query: queries) {
            arr[query.get(0)] += query.get(2);
            arr[query.get(1) + 1] -= query.get(2);
        }

        long runningSum = arr[0];
        long maxSum = arr[0];
        for (int i = 1; i < (arr.length - 1); i++) {
            runningSum+=arr[i];
            if(maxSum < runningSum)
                maxSum = runningSum;
        }

        return maxSum;

    }


}
