package lambda;

/**
 * User: MD.Ahmad
 * Date: 12/26/2019 4:44 PM
 */
public class Lambdas {

    public static void main(String[] args) {

        // Simple lambda example
        Runnable r = () -> System.out.println("Hello!");
        r.run();

    }
}
