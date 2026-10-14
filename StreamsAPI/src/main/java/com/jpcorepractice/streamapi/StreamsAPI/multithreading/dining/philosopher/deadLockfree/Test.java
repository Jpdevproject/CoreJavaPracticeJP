/*
package com.jpcorepractice.streamapi.StreamsAPI.multithreading.dining.philosopher.deadLockfree;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
    public static void main(String[] args) {
        Lock[] chopSticks=new ReentrantLock[5];
        for(int i=0;i<5;i++){
            chopSticks[i]=new ReentrantLock();
        }
        for(int i=0;i<5;i++){
            Lock left=chopSticks[i];
            Lock right=chopSticks[(i+1)%5];
            new Thread(()->{

            })
        }
    }
}
*/
