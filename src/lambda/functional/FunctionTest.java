package lambda.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * User: MD.Ahmad
 * Date: 12/31/2019 12:03 PM
 */
public class FunctionTest {

    public static void main(String[] args) {

        List<Integer> integers = List.of(1,2,3,4,5,6);

        //System.out.println(map(integers, integer -> integer * 2));


        Function<Integer, Integer> increment = i -> i + 1;

        Function<Integer, Integer> multiply = i -> i * 2;

        Function<Integer, Integer> combine = increment.andThen(multiply);

        System.out.println(combine.apply(2));

    }


    public static <T,R> List<R> map(List<T> list, Function<T, R> function){
        List<R> result = new ArrayList<>();
        for (T i: list)
            result.add(function.apply(i));
        return result;
    }
}
