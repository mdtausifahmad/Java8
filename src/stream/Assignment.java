package stream;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * User: MD.Ahmad
 * Date: 1/11/2020 2:47 PM
 *
 * Problem : Given two lists of numbers, how would you return all pairs of numbers?
 *           For example, given a list [1, 2, 3] and a list [3, 4] you should return
 *           [(1, 3), (1, 4), (2, 3), (2, 4), (3, 3), (3, 4)].
 *           For simplicity, you can represent a pair as an array with two elements.
 *
 *
 */
public class Assignment {

    public static void main(String[] args) {

        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);
        List<int[]> pairs =
                numbers1.stream()
                        .flatMap(i -> numbers2.stream()
                                .map(j -> new int[]{i, j})
                        )
                        .collect(toList());

        List<int[]> pairs2 =
                numbers1.stream()
                        .flatMap(i -> numbers2.stream()
                                .filter(j -> j+i % 3 == 0)
                                .map(j -> new int[]{i, j})
                        )
                        .collect(toList());

        System.out.println(pairs);

    }
}
