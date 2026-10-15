package printsequence;

import java.util.concurrent.Semaphore;

public class ABCPrinterUsingSemaphoreOptimized {
    private int cycles=5;
    private Semaphore semA=new Semaphore(1);
    private Semaphore semB=new Semaphore(0);
    private Semaphore semC=new Semaphore(0);

    private void print(char ch,Semaphore current,Semaphore next){
        try{
            for(int i=0;i<cycles;i++){
                current.acquire();
                System.out.println(ch);
                next.release();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ABCPrinterUsingSemaphoreOptimized printer=new ABCPrinterUsingSemaphoreOptimized();
        Thread t1=new Thread(()-> printer.print('A',printer.semA,printer.semB));
        Thread t2=new Thread(()->printer.print('B',printer.semB,printer.semC));
        Thread t3=new Thread(()->printer.print('C',printer.semC,printer.semA));

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

    }
}
