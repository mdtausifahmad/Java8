package generics.wildcard;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Unbounded {
    public static void main(String[] args) {
        List<?> stuff = Arrays.asList("Hello", LocalDate.now(), 3);

        System.out.println(stuff.size());
        stuff.forEach((Object o) -> System.out.println(o));

         //stuff.add(3);

        stuff.containsAll(Arrays.asList("Whatever", "else"));
        // AbstractCollection
    }
}
