package PreventOverSelling;

import java.util.concurrent.atomic.AtomicInteger;

public class Inventory {
    private final AtomicInteger stock;
    public Inventory(int initialStock) throws IllegalAccessException {
        if(initialStock<=0)
            throw new IllegalAccessException("Stock can not be negative");
        stock=new AtomicInteger(initialStock);
    }
    public boolean purchase(){
        while (true){
            int currentStock=stock.get();
            if(currentStock<=0)
                return false;
            if(stock.compareAndSet(currentStock,currentStock-1))
                return true;
        }
    }
    public int getStock(){
        return stock.get();
    }

    public static void main(String[] args) throws IllegalAccessException {
        Inventory inventory=new Inventory(1);
        System.out.println(inventory.purchase());
        System.out.println(inventory.purchase());
        System.out.println(inventory.getStock());
    }
}
