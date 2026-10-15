package counterproblem;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadSafeCounterUsingAtomicOperation {
    private static int maxCount=1000;
    public static class Counter{
        AtomicInteger count=new AtomicInteger(0);
        public void increment(){
            count.incrementAndGet();
        }
        public int getCount(){
            return count.get();
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Counter counter=new Counter();
        ExecutorService executorService= Executors.newFixedThreadPool(2);

        Future<?> f1=executorService.submit(()->{
            for(int i=0;i<maxCount;i++){
                counter.increment();
            }
        });

        Future<?> f2=executorService.submit(()->{
            for(int i=0;i<maxCount;i++){
                counter.increment();
            }
        });

        f1.get();
        f2.get();
        executorService.shutdown();
        System.out.println(counter.getCount());

    }
}
