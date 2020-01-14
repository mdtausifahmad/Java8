package lambda.exception;

import java.util.List;
import java.util.stream.Collectors;

/**
 * User: MD.Ahmad
 * Date: 1/14/2020 10:32 AM
 * Read :  https://www.oreilly.com/ideas/handling-checked-exceptions-in-java-streams
 *
 *
 */
public class Example1 {

    public static void main(String[] args) {

        List<Integer> integers = List.of(1,2,3,4,5,6,7,8,9);


       /* final List<Integer> scale = scale(integers, 2);

        scale.stream().forEach(System.out::println);
*/
        final List<Integer> scale1 = scale(integers, 0);

        scale1.stream().forEach(System.out::println);


    }

    public static List<Integer> scale(List<Integer> values, Integer factor) {
        return values.stream()
                .map(n -> n / factor)
                .collect(Collectors.toList());
    }
}
