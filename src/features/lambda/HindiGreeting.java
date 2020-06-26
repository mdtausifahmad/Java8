package features.lambda;

public class HindiGreeting implements Greeting {

    // Overriding the greet() method from Greeting interface.
    @Override
    public void greet() {
        System.out.println("Namaste");
    }
}
