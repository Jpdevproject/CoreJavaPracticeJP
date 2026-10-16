package ratelimiter;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class FixedWindowRateLimiter {
    private static class Bucket{
        long windowStart;
        int count;
        Bucket(long now){
            windowStart=now;
        }

    }
    private final ConcurrentHashMap<String,Bucket> buckets=new ConcurrentHashMap<>();

    private final int maxRequests;
    private final long windowMillis;
    public FixedWindowRateLimiter(int maxRequests,long windowMillis){
        this.maxRequests=maxRequests;
        this.windowMillis=windowMillis;
    }
    public boolean allow(String userId){
        long now=System.currentTimeMillis();
        Bucket bucket=buckets.computeIfAbsent(userId,id->new Bucket(now));
        synchronized (bucket){
            if(now- bucket.windowStart>=windowMillis){
                bucket.windowStart=now;
                bucket.count=0;
            }

            if(bucket.count>=maxRequests){
                return false;
            }
            bucket.count++;
            System.out.println(bucket.count);
            return true;
        }
    }
    public static void main(String[] args) throws InterruptedException {
//        FixedWindowRateLimiter limiter =
//                new FixedWindowRateLimiter(3, 5000);
//
//        String user = "jyoti";
//
//        for (int i = 1; i <= 5; i++) {
//            boolean allowed = limiter.allow(user);
//
//            System.out.println(
//                    "Request " + i + " -> " + allowed);
//        }


//        FixedWindowRateLimiter limiter =
//                new FixedWindowRateLimiter(3, 3000);
//
//        String user = "jyoti";
//
//        for (int i = 1; i <= 4; i++) {
//            System.out.println(
//                    "Request " + i + " -> "
//                            + limiter.allow(user));
//        }
//
//        System.out.println("Waiting for window reset...");
//
//        Thread.sleep(3500);
//
//        for (int i = 5; i <= 7; i++) {
//            System.out.println(
//                    "Request " + i + " -> "
//                            + limiter.allow(user));
//        }



        FixedWindowRateLimiter limiter =
                new FixedWindowRateLimiter(5, 10000);

        ExecutorService executor =
                Executors.newFixedThreadPool(20);

        for (int i = 1; i <= 20; i++) {

            int requestNo = i;

            executor.submit(() -> {
                boolean allowed =
                        limiter.allow("user1");

                System.out.println(
                        "Request " + requestNo +
                                " -> " + allowed);
            });
        }

        executor.shutdown();
        executor.awaitTermination(
                1,
                TimeUnit.MINUTES);
    }
}
