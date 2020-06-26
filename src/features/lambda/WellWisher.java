package features.lambda;

public class WellWisher {

    public static void wish(Greeting greeting) {
        greeting.greet();
    }

    /*public static void main(String args[]) {

        Greeting hindiGreeting = new HindiGreeting();
        wish(hindiGreeting);  // Passing an object of HindiGreeting.

        Greeting englishGreeting = new EnglishGreeting();
        wish(englishGreeting);  // Passing an object of EnglishGreeting.
    }*/

   /* public static void main(String args[]) {
        // We are passing an anonymous class object to the wish method.
        wish(new Greeting() {
            @Override
            public void greet() {
                System.out.println("Namaste");
            }
        });
    }*/


    // Passing a lambda expression to wish method.
    public static void main(String args[]) {
        wish( () -> System.out.println("Namaste") );
        wish(() -> System.out.println("Bonjour"));
    }
}

