package com.jpcorepractice.streamapi.StreamsAPI.multithreading.dining.philosopher;

import java.util.concurrent.locks.Lock;

public class Philosopher implements Runnable{
    private int id;
    private Lock leftChopstick;
    private Lock rightChopstick;
    public Philosopher(int id,Lock leftChopstick,Lock rightChopstick){
        this.id=id;
        this.leftChopstick=leftChopstick;
        this.rightChopstick=rightChopstick;
    }
    @Override
    public void run() {

            try {
                eat();
                think();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
    }

    private void think() throws InterruptedException {
        System.out.println("Philosopher with id "+id+" is thinking");
        Thread.sleep(5000);
    }

    private void eat() throws InterruptedException {
        leftChopstick.lock();
        System.out.println("Philosopher with id "+id+" has picked left chopstick");
        rightChopstick.lock();
        System.out.println("Philosopher with id "+id+" has picked right chopstick");
        System.out.println("Philosopher with id "+id+" is eating");
        Thread.sleep(5000);
        leftChopstick.unlock();
        rightChopstick.unlock();
    }
}
