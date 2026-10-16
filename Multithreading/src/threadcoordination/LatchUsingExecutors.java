package threadcoordination;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class LatchUsingExecutors {
    public static void main(String[] args){
        ExecutorService executorService= Executors.newFixedThreadPool(3);
        List<Future> futures=new ArrayList<>();

        for(int i=0;i<3;i++){
            final int serviceId=i;
            futures.add(executorService.submit(()->{

                try {
                    System.out.println("ServiceId :"+serviceId+" starting");
                    Thread.sleep(500);
                    System.out.println("ServiceId :"+serviceId+" ready");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

            }));
        }
        futures.stream().forEach((future -> {
            try {
                future.get();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } catch (ExecutionException e) {
                Thread.currentThread().interrupt();
            }
        }));
       System.out.println("All services are UP");

       executorService.shutdown();

    }
}
