package stream.collectingdatawithstreams;


import java.util.*;
import java.util.stream.Collectors;

/**
 * User: MD.Ahmad
 * Date: 1/25/2020 9:48 PM
 */
public class GroupingTransactionsImperative {
    public static void main(String[] args) {

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");

        List<Trader> traders = List.of(raoul,mario,alan,brian);

        List<Transaction> transactions = Arrays.asList(
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(brian, 2011, 300),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );



        Map<Currency, List<Transaction>> transactionsByCurrencies =
                new HashMap<>();

        for (Transaction transaction : transactions) {

            Currency currency = null;

            List<Transaction> transactionsForCurrency =
                    transactionsByCurrencies.get(currency);
            if (transactionsForCurrency == null) {
                transactionsForCurrency = new ArrayList<>();
                transactionsByCurrencies
                        .put(currency, transactionsForCurrency);
            }
            transactionsForCurrency.add(transaction);
        }


        final Map<Boolean, List<Transaction>> collect = transactions.stream().collect(Collectors.groupingBy(transaction -> transaction.getValue() > 400));

        collect.forEach((aBoolean, transactions1) -> {
            if(aBoolean == true){
                System.out.println(transactions1);
            }
        });
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
