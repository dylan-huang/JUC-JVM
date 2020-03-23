package com.atguigu.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


/**
 * 读写锁：写写，读写都需要互斥
 */
public class TestReadWriteLock {
    public static void main(String[] args) {
        ReadWriteLockDemo readWriteLockDemo = new ReadWriteLockDemo();

        new Thread(() -> {
            readWriteLockDemo.set(5);
        },"WRITE").start();
        for (int i=0;i<10;i++){
            new Thread(() -> {
                readWriteLockDemo.get();
            }).start();
        }


    }
}


class ReadWriteLockDemo{

    private  int number = 0;

    ReadWriteLock lock =  new ReentrantReadWriteLock();
    public void get(){

        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+" : "+number);
        }finally {
            lock.readLock().unlock();
        }

    }
    public void set(int number){

        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName());
            this.number=number;
        } finally {
            lock.writeLock().unlock();
        }

    }
}