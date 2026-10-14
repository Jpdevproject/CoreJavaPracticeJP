package oddevenprint;

public class OddEvenPrinter2 {
    private static int number=1;
    private final static int max=100;
    private static final Object lock=new Object();
    public static  class OddPrinter implements Runnable{

        @Override
        public synchronized void run() {
           while(number<=max){
               synchronized (lock){
                   while (number%2==0){
                       try {
                          lock.wait();
                       } catch (InterruptedException e) {
                           Thread.currentThread().interrupt();
                           return;
                       }
                   }
                   if(number<=max){
                       System.out.println("Thread:"+Thread.currentThread().getName()+" :Odd :"+number++);
                       lock.notifyAll();
                   }
               }

           }
        }
    }
    public static class EvenPrinter implements Runnable{

        @Override
        public synchronized void run() {
            while (number<=max){
                synchronized (lock){
                    while (number%2!=0){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    if(number<=max){
                        System.out.println("Thread :"+Thread.currentThread().getName()+" :Even :"+number++);
                        lock.notifyAll();
                    }
                }

            }
        }
    }
    public static void main(String[] args) {
        Thread t1=new Thread(new EvenPrinter());
        Thread t2=new Thread(new OddPrinter());
        t1.start();
        t2.start();


    }
}
