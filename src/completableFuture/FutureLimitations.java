package completableFuture;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class FutureLimitations {
    public static void main(String[] args) throws Exception{

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        final int Max = 10;

        for (int i = 0; i < Max; i++) {
           int index = i;
            Future<Integer> future = executorService.submit(() -> proces(Max, index));
            //get() will block and execution will be sequential. How to get value from the process method
            System.out.println(future.get());
        }

        executorService.shutdown();
        executorService.awaitTermination(20, TimeUnit.SECONDS);
    }

    private static int proces(int MAX, int index) {

        System.out.println("Starting Task "+index);
        sleep((MAX - index)*1000);
        System.out.println("Finishing Task "+index);
        return index;

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
