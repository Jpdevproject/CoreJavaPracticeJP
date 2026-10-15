package printsequence;

public class ABCPrinter {
    private int turn=0;
    private int cycles=5;

    public synchronized void print(char ch,int myTurn){
        for(int i=0;i<cycles;i++){
            while (turn!=myTurn){
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            System.out.print(ch+" ");
            turn=(turn+1)%3;
            notifyAll();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ABCPrinter printer=new ABCPrinter();
        Thread t1=new Thread(()->printer.print('A',0));
        Thread t2=new Thread(()->printer.print('B',1));
        Thread t3=new Thread(()->printer.print('C',2));
        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
    }
}
