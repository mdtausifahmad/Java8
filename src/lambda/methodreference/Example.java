package lambda.methodreference;

import behaviorParameterization.modal.Apple;

import java.util.function.Function;
import java.util.function.ToIntFunction;

/**
 * User: MD.Ahmad
 * Date: 12/31/2019 2:54 PM
 */
public class Example {

    public static void main(String[] args) {

        ToIntFunction<Apple> appleIntegerFunction = (Apple a) -> a.getWeight();

        //With method reference
        ToIntFunction<Apple> appleMethodReference = Apple::getWeight;

        final Runnable runnable = () -> Thread.currentThread().dumpStack();

        final Runnable runnableMethodReference = Thread::dumpStack;
    }
}
