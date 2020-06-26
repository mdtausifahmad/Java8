package features.staticmethod;

@FunctionalInterface
public interface Functional {
    void doSomething();

    default void foo() {
        System.out.println("foo");
    }

    static void boo(){

    }
}
