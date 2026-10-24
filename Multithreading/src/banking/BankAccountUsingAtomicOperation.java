package banking;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class BankAccountUsingAtomicOperation {
    private AtomicLong  balance=new AtomicLong(10000);

    public boolean withdraw(long amount){
        if(amount<=0|| balance.get()<amount){
            return false;
        }
        balance.compareAndSet(balance.get(),balance.addAndGet(-amount));
        return true;
    }
    public Long getBalance(){
        return balance.get();
    }
    public void deposit(long amount){
        if(amount<=0)
            throw new IllegalArgumentException("Amount can not be negative");
        balance.compareAndSet(balance.get(),balance.addAndGet(amount));
    }




    public static void main(String[] args) throws InterruptedException {
        BankAccountUsingAtomicOperation account=new BankAccountUsingAtomicOperation();
        ExecutorService pool= Executors.newFixedThreadPool(2);
        pool.submit(()->account.withdraw(1000));
        pool.submit(()->account.withdraw(2000));
        pool.submit(()->account.deposit(4000));


        pool.shutdown();
        pool.awaitTermination(1, TimeUnit.MINUTES);

        System.out.println( account.getBalance());

    }
}
