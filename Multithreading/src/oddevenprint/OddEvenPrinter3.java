package oddevenprint;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OddEvenPrinter3 {
    private int number=1;
    private final int max=100;

    public synchronized void printOdd(){
        while(number<=max){
            while(number%2==0){
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            if(number<=max){
                System.out.println("Thread:"+Thread.currentThread().getName()+" :Odd :"+number++);
                notifyAll();
            }
        }
    }
    public synchronized void printEven(){
        while (number<=max){
            while (number%2!=0){
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            if(number<=max){
                System.out.println("Thread :"+Thread.currentThread().getName()+" :Even :"+number++);
                notifyAll();
            }

        }
    }

    public static void main(String[] args) {
        OddEvenPrinter3 printer=new OddEvenPrinter3();
        ExecutorService service = Executors.newFixedThreadPool(2);
        service.submit(printer::printOdd);
        service.submit(printer::printEven);
        service.shutdown();
    }
}
