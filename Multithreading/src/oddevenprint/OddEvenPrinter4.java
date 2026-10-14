package oddevenprint;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class OddEvenPrinter4 {
    private int number=1;
    private final int max=100;

    private Lock lock=new ReentrantLock();
    private Condition oddCondition=lock.newCondition();
    private Condition evenCondition=lock.newCondition();

    private void printOdd(){
        while(true){
            lock.lock();
            try{
                while (number<=max && number%2==0){
                    oddCondition.await();
                }


                System.out.println(
                        Thread.currentThread().getName()
                                + " -> Odd : " + number);
                number++;
                evenCondition.signal();
                if(number>max){
                    evenCondition.signal();
                    return;
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }finally {
                lock.unlock();
            }
        }

    }
    private void printEven(){
        while(true){
            lock.lock();
            try{
                while(number<=max &&number%2!=0){
                    evenCondition.await();
                }

                System.out.println(
                        Thread.currentThread().getName()
                                + " -> Even : " + number);
                number++;
                oddCondition.signal();

                if(number>max){
                    oddCondition.signal();
                    return;
                }
            } catch (Exception e) {
                Thread.currentThread().interrupt();
                return;
            }finally {
                lock.unlock();
            }

        }

    }

    public static void main(String[] args) {
        OddEvenPrinter4 printer=new OddEvenPrinter4();
        ExecutorService service= Executors.newFixedThreadPool(2);
        service.submit(()->printer.printOdd());
        service.submit(()->printer.printEven());
        service.shutdown();
    }
}
