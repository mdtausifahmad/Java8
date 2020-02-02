package stream.collectingdatawithstreams;

import stream.Dish;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * User: MD.Ahmad
 * Date: 1/29/2020 9:32 AM
 */
public class ReducingAndSummarizationWithCollector {

    public static void main(String[] args) {

        final Long totalCount = Dish.menu.stream().collect(Collectors.counting());


        Comparator<Dish> dishCaloriesComparator =
                Comparator.comparingInt(Dish::getCalories);

        // Comparing dishes based on their calorie content
        final Optional<Dish> mostCalorieDish  = Dish.menu.stream().collect(Collectors.maxBy(dishCaloriesComparator));


        double avgCalories = Dish.menu.stream().collect(averagingInt(Dish::getCalories));

        //one time summarizing
        final IntSummaryStatistics statistics = Dish.menu.stream().collect(summarizingInt(Dish::getCalories));

        System.out.println(statistics.getAverage());
        System.out.println(statistics.getMin());
        System.out.println(statistics.getMax());
        System.out.println(statistics.getCount());
        System.out.println(statistics.getSum());


        //Joining Strings
        final String names = Dish.menu.stream().map(Dish::getName).collect(Collectors.joining(", "));

        System.out.println(names);


        //Generalized summarization with reduction
        int totalCalories = Dish.menu.stream().collect(reducing(
                0, Dish::getCalories, (i, j) -> i + j));


        Dish.menu.stream().collect(reducing((dish, dish2) -> dish.getCalories() > dish2.getCalories() ? dish : dish2));


        Stream<Integer> stream = Arrays.asList(1, 2, 3, 4, 5, 6).stream();

        List<Integer> numbers = stream.reduce(
                new ArrayList<Integer>(),
                (List<Integer> l, Integer e) -> {
                    l.add(e);
                    return l; },
                (List<Integer> l1, List<Integer> l2) -> {
                    l1.addAll(l2);
                    return l1; });


        final Map<Dish.Type, List<Dish>> groupByType = Dish.menu.stream().collect(groupingBy(Dish::getType));


        final Map<CaloricLevel, List<Dish>> collect = Dish.menu.stream().collect(groupingBy(dish -> {
            if (dish.getCalories() <= 400)
                return CaloricLevel.DIET;
            else if (dish.getCalories() > 400 && dish.getCalories() <= 700)
                return CaloricLevel.NORMAL;
            else
                return CaloricLevel.FAT;
        }));


    }
}
enum CaloricLevel { DIET, NORMAL, FAT };
