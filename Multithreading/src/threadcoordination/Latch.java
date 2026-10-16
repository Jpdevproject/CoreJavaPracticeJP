package threadcoordination;

import java.util.concurrent.CountDownLatch;

public class Latch {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch=new CountDownLatch(3);
        for(int i=0;i<3;i++){
            final int serviceId=i;
            new Thread(()->{
                    try {
                        System.out.println("ServiceId :"+serviceId+" starting");
                        Thread.sleep(500);
                        System.out.println("ServiceId :"+serviceId+" ready");
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }finally {
                        latch.countDown();
                    }
            }).start();
        }
        latch.await();
        System.out.println("All Services are UP");
    }
}
