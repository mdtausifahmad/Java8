package stream;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * User: MD.Ahmad
 * Date: 1/15/2020 9:53 PM
 */
public class PythagoreanTriplets {
    public static void main(String[] args) {
        Stream<int[]> pythagoreanTriples =
                IntStream.rangeClosed(1, 100).boxed()
                        .flatMap(a ->
                                IntStream.rangeClosed(a, 100)
                                        .filter(b -> Math.sqrt(a*a + b*b) % 1 == 0)
                                        .mapToObj(b ->
                                                new int[]{a, b, (int)Math.sqrt(a * a + b * b)})
                        );

        pythagoreanTriples.forEach(ints -> System.out.println(ints[0]+" "+ints[1]+" "+ints[2]));


    }
}
