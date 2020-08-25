package edu.knoldus.coursesera.weeks.one;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.stream.Collectors;

public class FindCommonElements {

    public static void main(String[] args) {
        Integer[][] arr = {{2,3,4,5,6,7} ,{3,4,5,6,7,8}, {6,7,8,9,10}};
        Optional<Integer[]> reduce = Arrays.stream(arr).reduce((x, y) -> {
            HashSet<Integer> hs1 = new HashSet<>();
            hs1.addAll(Arrays.stream(x).collect(Collectors.toList()));
            HashSet<Integer> hs2 = new HashSet<>();
            hs2.addAll(Arrays.stream(y).collect(Collectors.toList()));
            hs1.retainAll(hs2);
            return hs1.stream().toArray(Integer[]::new);
        });

Arrays.asList(1,3);

        System.out.println(Arrays.toString(reduce.get()));
    }
}
