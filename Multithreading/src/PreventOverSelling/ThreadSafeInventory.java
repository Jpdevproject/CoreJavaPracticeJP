package PreventOverSelling;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadSafeInventory {
    private final AtomicInteger stock;
    public ThreadSafeInventory(int initialStock){
        if(initialStock<=0)
            throw new IllegalArgumentException("initial stock can not be less or equal to Zero");
        stock=new AtomicInteger(initialStock);
    }
    public boolean reserve(int quantity){
        if(quantity<=0)
            throw new IllegalArgumentException("Quantity must be positive");
        while (true){
            int current=stock.get();
            if(current<=0)
                return false;
            if(stock.compareAndSet(current,current-quantity))
                return true;
        }
    }
    public int getStock(){
        return stock.get();
    }

    public static void main(String[] args) {
        ThreadSafeInventory inventory=new ThreadSafeInventory(1);
        System.out.println(inventory.reserve(1));
        System.out.println(inventory.reserve(1));
        System.out.println(inventory.getStock());

    }
}
