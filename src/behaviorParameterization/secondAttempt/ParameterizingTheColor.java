package behaviorParameterization.secondAttempt;

import behaviorParameterization.modal.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: MD.Ahmad
 * Date: 12/24/2019 5:41 PM
 */
public class ParameterizingTheColor {

    public static void main(String[] args) {


        List<Apple> inventory = Arrays.asList(new Apple(80,"green"),
                new Apple(155, "green"),
                new Apple(120, "red"));

        List<Apple> greenApples = filterApplesByColor(inventory, "green");
        System.out.println(greenApples);

        // [Apple{color='red', weight=120}]
        List<Apple> redApples = filterApplesByColor(inventory, "red");
        System.out.println(redApples);

    }

    public static List<Apple> filterApplesByColor(List<Apple> inventory, String color){
        List<Apple> result = new ArrayList<>();
        for(Apple apple: inventory){
            if(apple.getColor().equals(color)){
                result.add(apple);
            }
        }
        return result;
    }
}
