package counterproblem;

import java.util.concurrent.*;

public class ThreadSafeCounterUsingExecutors {
    private static int maxCount=1000;
    public  static class Counter{
        private int count=0;

        public synchronized void increment(){
            count++;
        }
        public  int getCount(){
            return count;
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Counter counter=new Counter();
        ExecutorService service= Executors.newFixedThreadPool(2);

        Future<?> f1= service.submit(()->{
            for(int i=0;i<maxCount;i++){
                counter.increment();
            }
        });
        Future<?> f2=service.submit(()->{
            for(int i=0;i<maxCount;i++){
                counter.increment();
            }
        });
        f1.get();
        f2.get();

        service.shutdown();
       // service.awaitTermination(1, TimeUnit.MINUTES);
        System.out.println(counter.getCount());

    }

}
