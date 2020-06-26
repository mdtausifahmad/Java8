package features.staticmethod;

/**
 * Suppose you want to provide some implementation in your interface and you
 * don’t want this implementation to be overridden in the implementing class,
 * then you can declare the method as static.
 */
public interface Vehicle {

    static void cleanVehicle(){
        System.out.println("I am cleaning vehicle");
    }
}
