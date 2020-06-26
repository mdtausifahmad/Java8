package features.builtinfunctional;

import features.lambda.comparatorwith.Person;

import java.util.function.Predicate;

public class PredicateDemo {

  static boolean isPersonEligibleForRetirement(Person person, Predicate<Person> predicate){
    return predicate.test(person);
  }


  static boolean isPersonEligibleForVoting(Person person, Predicate<Person> predicate){
    return predicate.test(person);
  }

  static boolean isPersonEligibleForMembership(Person person, Predicate<Person> predicate){
    return predicate.test(person);
  }


  public static void main (String args[]){

    Person person = new Person("Alex", 23);

    // Created a predicate. It returns true if age is greater than 18.
    Predicate<Person> greaterThanEighteen = (p) -> p.getAge() > 18;

    // Created a predicate. It returns true if age is less than 60.
    Predicate<Person> lessThanSixty = (p) -> p.getAge() < 60;

    Predicate<Person> predicate = greaterThanEighteen.and(lessThanSixty);

    boolean eligible = isPersonEligibleForMembership(person , predicate);
    System.out.println("Person is eligible for membership: " + eligible);
  }
}
