package counterproblem;

public class ThreadSafeCounter {
    private static int maxCount=1000;
    public static  class Counter{
        private int count=0;


        public synchronized void increment(){
            count++;
        }
        public int getCount(){
            return count;
        }
    }

    public static void main(String[] args) {
        Counter counter=new Counter();
        Thread t1=new Thread(()->{
            for (int i=0;i<maxCount;i++){
                counter.increment();
            }

        });
        Thread t2=new Thread(()->{
            for(int i=0;i<maxCount;i++){
                counter.increment();
            }

        });
        t1.start();
        t2.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(counter.getCount());

    }
}
