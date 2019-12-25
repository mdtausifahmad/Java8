package behaviorParameterization.thirdattempt;

import behaviorParameterization.modal.Apple;
import behaviorParameterization.thirdattempt.predicate.ApplePredicate;
import behaviorParameterization.thirdattempt.predicateImpl.AppleColorPredicate;
import behaviorParameterization.thirdattempt.predicateImpl.AppleRedAndHeavyPredicate;
import behaviorParameterization.thirdattempt.predicateImpl.AppleWeightPredicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: MD.Ahmad
 * Date: 12/25/2019 11:14 AM
 */
public class FilterAbstractCriteria {


    public static void main(String[] args) {


        List<Apple> inventory = Arrays.asList(new Apple(80,"green"),
                new Apple(155, "green"),
                new Apple(120, "red"));



        // [Apple{color='green', weight=80}, Apple{color='green', weight=155}]
        List<Apple> greenApples2 = filter(inventory, new AppleColorPredicate());
        System.out.println(greenApples2);

        // [Apple{color='green', weight=155}]
        List<Apple> heavyApples = filter(inventory, new AppleWeightPredicate());
        System.out.println(heavyApples);

        // []
        List<Apple> redAndHeavyApples = filter(inventory, new AppleRedAndHeavyPredicate());
        System.out.println(redAndHeavyApples);

        // [Apple{color='red', weight=120}]
        List<Apple> redApples2 = filter(inventory, new ApplePredicate() {
            public boolean test(Apple a){
                return a.getColor().equals("red");
            }
        });
        System.out.println(redApples2);


        List<Apple> heavyThan200  = filter(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple a) {
                return a.getWeight() > 200;
            }
        });

    }

    public static List<Apple> filter(List<Apple> inventory, ApplePredicate p){
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory){
            if(p.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }

}
