package completableFuture;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class FutureAndException {

    public static void main(String[] args) throws Exception {


        ExecutorService executorService = Executors.newFixedThreadPool(100);


        Future<Integer> result = executorService.submit(() -> proces());

        sleep(2000);
        System.out.println("Cancelling...");
        result.cancel(true);

        if(result.isCancelled())
         System.out.println(result.get());

        executorService.shutdown();
        executorService.awaitTermination(20, TimeUnit.SECONDS);
    }

    private static int proces() {

        System.out.println("Starting work...");

        if(sleep(10000)){
            System.out.println("Done work...");
            return 2;
        }

        return 0;
    }

    private static boolean sleep(int i) {
        try {
            Thread.sleep(i);
            return true;
        } catch (InterruptedException e) {
            System.out.println("Interrupted...");
            return false;
        }
    }
}
