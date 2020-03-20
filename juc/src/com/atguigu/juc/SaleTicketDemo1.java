package com.atguigu.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SaleTicketDemo1 {

    public static void main(String[] args) {

        Ticket ticket = new Ticket();

        new Thread(() -> { for (int i=0;i<40;i++) ticket.sale(); },"A");
        new Thread(() -> { for (int i=0;i<40;i++) ticket.sale(); },"B");
        new Thread(() -> { for (int i=0;i<40;i++) ticket.sale(); },"C");
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<40;i++){
                    // 线程状态 NEW，RUNNING，WAITING（死等），TIMED_WAITING（有时间的等待），BLOCKED，TERMINATED
                    ticket.sale();
                }
            }
        }, "A").start();

       /* new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<40;i++){
                    // 线程状态 NEW，RUNNING，WAITING（死等），TIMED_WAITING（有时间的等待），BLOCKED，TERMINATED
                    ticket.sale();
                }
            }
        }, "A").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<40;i++){
                    // 线程状态 NEW，RUNNING，WAITING（死等），TIMED_WAITING（有时间的等待），BLOCKED，TERMINATED
                    ticket.sale();
                }
            }
        }, "B").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<40;i++){
                    // 线程状态 NEW，RUNNING，WAITING（死等），TIMED_WAITING（有时间的等待），BLOCKED，TERMINATED
                    ticket.sale();
                }
            }
        }, "C").start();*/
    }
}


class Ticket {
    private int number = 30;

    Lock lock = new ReentrantLock(); //可重入锁

    public void sale() {
        lock.lock();
        try {
            if (number > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出第" + number-- + "张票，还剩" + number + "张");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
