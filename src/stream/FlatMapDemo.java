package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * User: MD.Ahmad
 * Date: 1/12/2020 9:25 PM
 */
public class FlatMapDemo {

    public static void main(String[] args) {

       /* String[] words = {"Hello","World"};

        final List<String> collect = Arrays.stream(words)
                .map(word -> word.split(" "))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(toList());

        System.out.println(collect);*/

        List<String> words = Arrays.asList("Hello", "World");

        List<Integer> wordLengths = words.stream()
                .map(String::length)
                .collect(toList());
        System.out.println(wordLengths);

        // flatMap
        words.stream()
                .flatMap((String line) -> Arrays.stream(line.split("")))
                .distinct()
                .forEach(System.out::println);


    }
}
