package completableFuture;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class FutureAndException {

    public static void main(String[] args) throws Exception {


        ExecutorService executorService = Executors.newFixedThreadPool(100);


        Future<Integer> result = executorService.submit(() -> proces());

        System.out.println(result.isDone());

        sleep(10000);

        System.out.println(result.isDone());
        System.out.println(result.get());

        executorService.shutdown();
        executorService.awaitTermination(20, TimeUnit.SECONDS);
    }

    private static int proces() {

        System.out.println("Starting work...");

        sleep(10000);

        System.out.println("Done work...");
        return 2;
    }

    private static void sleep(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
