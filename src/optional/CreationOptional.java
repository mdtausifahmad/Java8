package optional;

import java.util.Optional;

/**
 * User: MD.Ahmad
 * Date: 1/9/2020 10:52 PM
 */
public class CreationOptional {

    public static void main(String[] args) {

        //Empty optional
        Optional<Car> optCar = Optional.empty();


        //Optional from a non-null value
        Car car = new Car();
        Optional<Car> optCar1 = Optional.of(car);


        Car car2 = null;
        Optional<Car> optCar2 = Optional.ofNullable(car);


        /*
        String name = null;
        if(insurance != null){
            name = insurance.getName();
        }

        The same thing can be written in
        */
        Insurance insurance = null;
        Optional<Insurance> optInsurance = Optional.ofNullable(insurance);
        Optional<String> name = optInsurance.map(Insurance::getName);
    }

    public String getCarInsuranceName(Person person) {
        //return person.getCar().getInsurance().getName();

        Optional<Person> optPerson = Optional.of(person);
   /*     Optional<String> name =
                optPerson.map(Person::getCar)
                        .map(Car::getInsurance)
                        .map(Insurance::getName);
*/
        return null;
    }
}

class Person {
    private Optional<Car> car;
    public Optional<Car> getCar() { return car; }
}
class Car {
    private Optional<Insurance> insurance;
    public Optional<Insurance> getInsurance() { return insurance; }
}
class Insurance {
    private String name;
    public String getName() { return name; }
}
