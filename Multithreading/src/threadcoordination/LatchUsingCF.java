package threadcoordination;

import java.util.concurrent.CompletableFuture;

public class LatchUsingCF {
    public static void main(String[] args) {
        CompletableFuture[] futures=new CompletableFuture[3];
        for(int i=0;i<3;i++){
            final int serviceId=i;
           futures[i] =CompletableFuture.runAsync(()->service(serviceId));
        }
        CompletableFuture.allOf(futures).join();
        System.out.println("All services are UP");

    }

    private static void service(int id){
        try {
            System.out.println("ServiceId :"+id+" Starting");
            Thread.sleep(500);
            System.out.println("ServiceId :"+id+" Ready");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
