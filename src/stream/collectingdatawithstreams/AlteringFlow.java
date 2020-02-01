package stream.collectingdatawithstreams;

public class AlteringFlow {

    private static boolean readyToExit = false;

    private void printHello() {
        System.out.println("Hello");
        //more code goes here
        readyToExit = true;
    }

    public static void main(String[] args) {
        AlteringFlow af = new AlteringFlow();
        af.printHello();
        if (!readyToExit) main(null); // line n1
    }
}
