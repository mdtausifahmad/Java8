package stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * User: MD.Ahmad
 * Date: 1/18/2020 12:33 PM
 */
public class Play {

    public static void main(String[] args) {

        List<Integer> integers = List.of(1,2,3,4);

        final List<int[]> ints = integers.stream()
                .flatMap(integer -> integers.stream()
                        .map(integer1 -> new int[]{integer, integer1}))
                .collect(Collectors.toList());

        ints.stream().forEach(ints1 -> System.out.println(ints1[0]+" "+ints1[1]));


    }
}
