package lambda.functional;

import behaviorParameterization.modal.Apple;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * User: MD.Ahmad
 * Date: 12/26/2019 5:38 PM
 */
public class PredicateTest {

    public static void main(String[] args) {

        List<String> names = List.of("Tausif","ahmad","nahid","kahkasha","apple");

        Predicate<String> startsWithA = (String s) -> s.startsWith("a");

        Predicate<String> isEmpty = s -> s.isEmpty();

        System.out.println(filter(names,startsWithA));


        Predicate<Apple> redApple = apple -> apple.getColor().equalsIgnoreCase("red");

        Predicate<Apple> notRedApple = redApple.negate();

        Predicate<Apple> heavyApple = apple -> apple.getWeight() > 150;

        Predicate<Apple> readAndHeavyApple = redApple.and(heavyApple);

    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> results = new ArrayList<>();
        for (T s : list) {
            if (p.test(s)) {
                results.add(s);

            }
        }
        return results;
    }

}
