package stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * User: MD.Ahmad
 * Date: 1/15/2020 9:10 PM
 */
public class TraderAssignment {

    public static void main(String[] args) {

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");

        List<Trader> traders = List.of(raoul,mario,alan,brian);

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        //Find all transactions in the year 2011 and sort them by value (small to high).
        final List<Transaction> year11 = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());
        //System.out.println(year11);

        //What are all the unique cities where the traders work?
        final Stream<String> distinctCities = traders.stream()
                .map(Trader::getCity)
                .distinct();

        //Find all traders from Cambridge and sort them by name.
        traders.stream()
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .sorted(Comparator.comparing(Trader::getName))
                .forEach(System.out::println);

        //Return a string of all traders’ names sorted alphabetically.
        final Optional<String> reduce = traders.stream()
                .map(Trader::getName)
                .distinct()
                .sorted()
                .reduce((s, s2) -> s.concat(s2));
        System.out.println(reduce);


        //Are any traders based in Milan?
        final boolean milan = traders.stream().anyMatch(trader -> trader.getCity().equals("Milan"));

        //Print the values of all transactions from the traders living in Cambridge.
        transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .forEach(System.out::println);

        //What’s the highest value of all the transactions?
        transactions.stream().map(Transaction::getValue).reduce(Integer::max);

        //Find the transaction with the smallest value.
        transactions.stream().min(Comparator.comparing(Transaction::getValue));

        final int sum = transactions.stream()
                .mapToInt(Transaction::getValue)
                .sum();

        final OptionalInt max = transactions.stream()
                .mapToInt(Transaction::getValue)
                .max();

        IntStream.rangeClosed(1,100)
                .forEach(System.out::println);
    }
}

class Trader{
    private final String name;
    private final String city;
    public Trader(String n, String c){
        this.name = n;
        this.city = c;
    }
    public String getName(){
        return this.name;
    }
    public String getCity(){
        return this.city;
    }
    public String toString(){
        return "Trader:"+this.name + " in " + this.city;
    }
}

class Transaction{
    private final Trader trader;
    private final int year;
    private final int value;
    public Transaction(Trader trader, int year, int value){
        this.trader = trader;
        this.year = year;
        this.value = value;
    }
    public Trader getTrader(){
        return this.trader;
    }
    public int getYear(){
        return this.year;
    }
    public int getValue(){
        return this.value;
    }
    public String toString(){
        return "{" + this.trader + ", " +
                "year: "+this.year+", " +
                "value:" + this.value +"}";
    }
}
