package oddevenprint;

public class OddEvenPrinter {
    private int number=1;
    private final int max=100;

    public synchronized void printOdd(){
        while (number<=max){
            while (number%2==0){
                try{
                    wait();
                }catch (InterruptedException ex){
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            if(number<=max){
                System.out.println("Odd:"+number++);
                notifyAll();
            }
        }

    }
    public synchronized void printEven(){
        while (number<=max){
            while (number%2!=0){
                try{
                    wait();
                }catch (InterruptedException ex){
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            if(number<=max){
                System.out.println("Even :"+number++);
                notifyAll();
            }
        }
    }
    public static void main(String[] args) {
        OddEvenPrinter printer=new OddEvenPrinter();
        Thread t1=new Thread(()->printer.printOdd());
        Thread t2=new Thread(()-> printer.printEven());
        t1.start();
        t2.start();

    }
}
