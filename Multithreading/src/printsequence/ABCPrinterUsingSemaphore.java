package printsequence;

import java.util.concurrent.Semaphore;

public class ABCPrinterUsingSemaphore {
    private int cycles=5;
    private Semaphore semA=new Semaphore(1);
    private Semaphore semB=new Semaphore(0);
    private Semaphore semC=new Semaphore(0);

    public void printA(){
        try{
            for(int i=0;i<cycles;i++){
                semA.acquire();
                System.out.println("A");
                semB.release();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void printB(){
        try{
            for (int i=0;i<cycles;i++){
                semB.acquire();
                System.out.println("B");
                semC.release();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    public void printC(){
        try{
            for (int i=0;i<cycles;i++){
                semC.acquire();
                System.out.println("C");
                semA.release();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ABCPrinterUsingSemaphore printer=new ABCPrinterUsingSemaphore();

        Thread t1=new Thread(printer::printA);
        Thread t2=new Thread(printer::printB);
        Thread t3=new Thread(printer::printC);
        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
    }
}
