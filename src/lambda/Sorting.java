package lambda;

import behaviorParameterization.modal.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * User: MD.Ahmad
 * Date: 12/31/2019 4:09 PM
 */
public class Sorting {

    public static void main(String[] args) {


        List<Apple> inventory = new ArrayList<>();
        inventory.addAll(Arrays.asList(new Apple(80,"green"), new Apple(155, "green"), new Apple(120, "red")));

        //Step. 1
        inventory.sort(new AppleComparator());
        System.out.println(inventory);


        //Step 2: Use an anonymous class
        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight() - o2.getWeight();
            }
        });

        // reshuffling things a little
        inventory.set(1, new Apple(20, "red"));

        //Step 3: Use lambda expressions
        inventory.sort((o1, o2) -> o1.getWeight().compareTo(o2.getWeight()));

        // reshuffling things a little
        inventory.set(1, new Apple(10, "red"));

        //Step 4: Use method references
        inventory.sort(Comparator.comparing(Apple::getWeight));


        //for reverse order
        inventory.sort(Comparator.comparing(Apple::getWeight).reversed());

        inventory.sort(Comparator.comparing(Apple::getWeight)
                .reversed()
                .thenComparing(Apple::getColor)
                .thenComparing(Apple::toString)
        );

    }

    static class AppleComparator implements Comparator<Apple> {
        public int compare(Apple a1, Apple a2){
            return a1.getWeight().compareTo(a2.getWeight());
        }
    }
}
