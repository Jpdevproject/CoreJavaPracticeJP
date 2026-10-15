package ProducerConsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerImpl {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue=new ArrayBlockingQueue<>(5);

        Thread producer=new Thread(()->{
          try{
              for(int i=1;i<=10;i++){
                  queue.put(i);
                  System.out.println("Produced: "+i);
              }
              queue.put(-1);
          } catch (InterruptedException e) {
              Thread.currentThread().interrupt();
          }
        });

        Thread consumer=new Thread(()->{
            try{
                while (true){
                    int item=queue.take();
                    if(item==-1)
                        break;
                    System.out.println("Consumed :"+item);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();

    }
}
