package iteration;

import java.util.Arrays;
import java.util.List;

public class ImperativeToDeclarative {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7);

        for (int i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.get(i));
        }

        //First Improvements
        for(int element : numbers){
            System.out.println(element);
        }

        //Second Improvements
        numbers.forEach(System.out::println);

    }
}
