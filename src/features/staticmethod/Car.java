package features.staticmethod;

/*
public class Car implements Vehicle {
    
    @Override
    public void cleanVehicle() {
        System.out.println("Cleaning the vehicle");
    }

    public static void main(String args[]) {
        Car car = new Car();
        car.cleanVehicle();

    }
}
*/

public class Car implements Vehicle {

    public static void main(String args[]){
        Car car = new Car();

        //car.cleanVehicle();  //This will not compile.
        Vehicle.cleanVehicle(); //This will compile.

    }
}

