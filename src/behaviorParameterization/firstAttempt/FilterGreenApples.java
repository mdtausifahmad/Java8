package behaviorParameterization.firstAttempt;

import behaviorParameterization.modal.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: MD.Ahmad
 * Date: 12/24/2019 5:37 PM
 */
public class FilterGreenApples {


    public static void main(String[] args) {

        List<Apple> inventory = Arrays.asList(new Apple(80,"green"),
                new Apple(155, "green"),
                new Apple(120, "red"));

        System.out.println(filterGreenApples(inventory));

    }

    public static List<Apple> filterGreenApples(List<Apple> inventory){

        List<Apple> result = new ArrayList<>();
        for(Apple apple: inventory){
            if("green".equals(apple.getColor())){
                result.add(apple);
            }
        }
        return result;
    }
}
