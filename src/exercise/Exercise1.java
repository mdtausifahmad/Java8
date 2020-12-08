package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Exercise1 {



    public static boolean isEven(int num){
        return num % 2 == 0;
    }

    public static void main(String[] args) {

        List<Double> sqrOfFirst100evens = new ArrayList<>();

        int index = 1;
        while (sqrOfFirst100evens.size() < 100){
            if (isEven(index))
             sqrOfFirst100evens.add(Math.sqrt(index));

            index++;
        }





        //Functional Style 1
        List<Double> collect = IntStream.range(1, 100)
                .filter(value -> isEven(value))
                .mapToDouble(operand -> Math.sqrt(operand))
                .boxed()
                .collect(Collectors.toList());


        Stream.iterate(1, integer -> integer + 1)
                .filter(Exercise1::isEven)
                .limit(100)
                .map(Math::sqrt)
                .collect(Collectors.toList());

        System.out.println(
                String.format("Computed %d values, first %g, last %g",
                        collect.size(),collect.get(0),
                        collect.get(collect.size() -1))
        );


    }
}
