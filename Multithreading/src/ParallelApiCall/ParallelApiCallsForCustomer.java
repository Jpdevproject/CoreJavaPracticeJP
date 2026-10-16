package ParallelApiCall;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ParallelApiCallsForCustomer {
    public static void main(String[] args) {
        ExecutorService pool= Executors.newFixedThreadPool(2);
        try{
            CompletableFuture<String> customer=CompletableFuture.supplyAsync(()->fetchCustomer(),pool);
            CompletableFuture<String> orders=CompletableFuture.supplyAsync(()->fetchOrders(),pool);

            CompletableFuture<String> combined=customer.thenCombine(orders,(c,o)->Thread.currentThread()+c+"|"+Thread.currentThread()+o);
            System.out.println(combined.join());
        }finally {
            pool.shutdown();
        }
    }

    private static String fetchCustomer() {
        return "Customer Details";
    }
    private static String fetchOrders(){
        return "Order Details";
    }
}
