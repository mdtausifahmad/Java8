package behaviorParameterization.finalattempt;

import behaviorParameterization.modal.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: MD.Ahmad
 * Date: 12/25/2019 11:25 AM
 */
public class AbstractOverListTypes {

    public static void main(String[] args) {

        List<Apple> inventory = Arrays.asList(new Apple(80,"green"),
                new Apple(155, "green"),
                new Apple(120, "red"));

        List<String> names = List.of("tausif","ahmad","nahid","kahkasha");

        List<Apple> redApples = filter(inventory,(Apple apple) -> apple.getWeight() > 150);

        //String s = "Tausif";
        //System.out.println(s.startsWith("T"));

        List<String> namesstartsWithT = filter(names,s -> s.startsWith("S"));

    }


    public static <T> List<T> filter(List<T> list, Predicate<T> predicate){
        List<T> result = new ArrayList<>();

        list.stream().forEach( (T t) -> {
            if(predicate.test(t))
                result.add(t);
        });
        return  result;
    }
}
