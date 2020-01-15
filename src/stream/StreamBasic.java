package stream;

import java.util.*;
import java.util.stream.Collectors;

/**
 * User: MD.Ahmad
 * Date: 1/1/2020 4:27 PM
 */
public class StreamBasic {

    public static void main(String[] args) {

        List<String> strings = null;//List.of("a","b","c","d");

        Optional.ofNullable(strings).stream().forEach(strings1 -> {
            strings1.forEach(System.out::println);
        });


        List<Integer> numbers = List.of(1,2,3,4,5,6);
        int sum = numbers.stream().reduce(0, (a, b) -> a + b);

        Optional<Integer> sum1 = numbers.stream().reduce((integer, integer2) -> integer + integer2);

        int product = numbers.stream().reduce(1, (a, b) -> a * b);

        Optional<Integer> max = numbers.stream().reduce(Integer::max);

        Optional<Integer> min = numbers.stream().reduce(Integer::min);

        System.out.println(sum1.get());


    }

    public static List<String> getLowCaloricDishesNamesInJava7(List<Dish> dishes){
        List<Dish> lowCaloricDishes = new ArrayList<>();
        for(Dish d: dishes){
            if(d.getCalories() < 400){
                lowCaloricDishes.add(d);
            }
        }
        List<String> lowCaloricDishesName = new ArrayList<>();
        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            public int compare(Dish d1, Dish d2){
                return Integer.compare(d1.getCalories(), d2.getCalories());
            }
        });
        for(Dish d: lowCaloricDishes){
            lowCaloricDishesName.add(d.getName());
        }
        return lowCaloricDishesName;
    }


    public static List<String> getLowCaloricDishesNamesInJava8(List<Dish> dishes){
        return dishes.stream()
                .filter(dish -> dish.getCalories() < 400)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(Collectors.toList());
    }
}
