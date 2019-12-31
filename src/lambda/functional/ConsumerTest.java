package lambda.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * User: MD.Ahmad
 * Date: 12/31/2019 11:57 AM
 */
public class ConsumerTest {

    public static void main(String[] args) {
        forEach(List.of(1,2,5,8,9,12,54,67),System.out::print);
    }


    public static  <T> void forEach(List<T> list, Consumer<T> p) {
        for(T i: list){
            p.accept(i);
        }
    }
}
