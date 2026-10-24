package banking;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BankAccount {
    private long balance =10000;
    public synchronized boolean withdraw(long amount){
        if(amount<=0|| balance <amount)
            return false;
        balance -=amount;
        return true;
    }
    public synchronized long getBalance(){
        return balance;
    }
    public synchronized void deposit(long amount){
        if(amount<=0)
            throw new IllegalArgumentException("Amount must be positive");
        balance+=amount;
    }
    public static void main(String[] args) throws InterruptedException {
        BankAccount account=new BankAccount();
//        Thread t1=new Thread(()->account.withdraw(1000));
//        Thread t2=new Thread(()->account.withdraw(2000));
//        t1.start();
//        t2.start();
        ExecutorService pool= Executors.newFixedThreadPool(2);
        pool.submit(()->account.withdraw(1000));
        pool.submit(()->account.withdraw(2000));

        pool.shutdown();
        pool.awaitTermination(1, TimeUnit.MINUTES);



        System.out.println( account.getBalance());
    }
}
