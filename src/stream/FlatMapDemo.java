package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * User: MD.Ahmad
 * Date: 1/12/2020 9:25 PM
 */
public class FlatMapDemo {

    public static void main(String[] args) {

        String[] words = {"Hello","World"};

        final List<String> collect = Arrays.stream(words)
                .map(word -> word.split(" "))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());

        System.out.println(collect);

    }
}
