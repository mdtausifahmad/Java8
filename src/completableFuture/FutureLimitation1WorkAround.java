package completableFuture;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 1. Blocking call when we call get
 * 2. Exception don't reveal them shelf until we call get()
 */
public class FutureLimitation1WorkAround {
    public static void main(String[] args) throws Exception{

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        final int Max = 10;

        List<Future<Integer>> futures = new ArrayList<>();

        for (int i = 0; i < Max; i++) {
           int index = i;
             futures.add(executorService.submit(() -> proces(Max, index)));
        }

        System.out.println("Scheduled task to run...");

        for (Future<Integer> future: futures){
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
