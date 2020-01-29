package stream.collectingdatawithstreams;

import stream.Dish;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * User: MD.Ahmad
 * Date: 1/29/2020 9:32 AM
 */
public class ReducingAndSummarizationWithCollector {

    public static void main(String[] args) {

        final Long totalCount = Dish.menu.stream().collect(Collectors.counting());

        //System.out.println(totalCount);

        System.out.println(Dish.menu.stream().count());

        Comparator<Dish> dishCaloriesComparator =
                Comparator.comparingInt(Dish::getCalories);

        // Comparing dishes based on their calorie content
        final Optional<Dish> mostCalorieDish  = Dish.menu.stream().collect(Collectors.maxBy(dishCaloriesComparator));

    }
}
