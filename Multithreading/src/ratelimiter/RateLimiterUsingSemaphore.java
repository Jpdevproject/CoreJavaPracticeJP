package ratelimiter;

import java.util.concurrent.*;

public class RateLimiterUsingSemaphore {
    private final Semaphore permits;
    public RateLimiterUsingSemaphore(int maxConcurrentCall){
        this.permits=new Semaphore(maxConcurrentCall);
    }

    public<T> T execute(Callable<T> action) throws Exception {
        if(!permits.tryAcquire(200, TimeUnit.MILLISECONDS)){
            throw new IllegalArgumentException("Too many concurrent Requests ...");
        }
        try{
            return action.call();
        }finally {
            permits.release();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        RateLimiterUsingSemaphore rateLimiter =
                new RateLimiterUsingSemaphore(2);

        ExecutorService executor =
                Executors.newFixedThreadPool(5);

        for (int i = 1; i <= 5; i++) {

            int taskId = i;

            executor.submit(() -> {
                try {

                    String result = rateLimiter.execute(() -> {

                        System.out.println(
                                "Task " + taskId +
                                        " acquired permit by " +
                                        Thread.currentThread().getName());

                        Thread.sleep(1000);

                        System.out.println(
                                "Task " + taskId +
                                        " completed");

                        return "SUCCESS";
                    });

                    System.out.println(
                            "Task " + taskId +
                                    " -> " + result);

                } catch (Exception e) {

                    System.out.println(
                            "Task " + taskId +
                                    " -> " + e.getMessage());
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);


    }
}
