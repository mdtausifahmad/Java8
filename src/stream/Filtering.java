package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * User: MD.Ahmad
 * Date: 1/11/2020 2:12 PM
 */
public class Filtering {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);



        List<Dish> specialMenu = Arrays.asList(
                new Dish("seasonal fruit", true, 120, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER));



        //select the dishes that have fewer than 320 calories
        List<Dish> filteredMenu
                = specialMenu.stream()
                .filter(dish -> dish.getCalories() < 320)
                .collect(toList());


        //initial list was already sorted on the number of calories but still we have
        // to iterate the whole list to find the dish which has calories > 320
        // to avoid full iteration over the stream
        List<Dish>  slicedMenu = specialMenu
                .stream()
                .takeWhile(dish -> dish.getCalories() > 320)
                .collect(Collectors.toList());


        //first 2 meat dish
        List<Dish> meatDish = specialMenu.stream()
                .filter(dish -> dish.getType().name().equals(Dish.Type.MEAT))
                .limit(2)
                .collect(Collectors.toUnmodifiableList());



        //count no of dishes
        final long count = Dish.menu.stream().count();
        System.out.println("Count " +count);
    }



}
