package com.atguigu.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多线程之间按顺序调用 A->B->C
 *
 * 要求：
 * AA打印5次，BB打印10次，CC打印15次，循环10次, JUC 可以精确通知
 */

class ShareData{

    private int number = 1; //A:1,B:2,C:3
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    public void print5(){

        lock.lock();
        try {
            //判断
            while (1!=number){
                c1.await();
            }
            for (int i=1;i<=5;i++){
                System.out.println(Thread.currentThread().getName()+ "  "+i);
            }
            //修改flag
            number=2;
            c2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void print10(){

        lock.lock();
        try {
            //判断
            while (2!=number){
                c2.await();
            }
            for (int i=1;i<=10;i++){
                System.out.println(Thread.currentThread().getName()+ "  "+i);
            }
            //修改flag
            number=3;
            c3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void print15(){

        lock.lock();
        try {
            //判断
            while (3!=number){
                c1.await();
            }
            for (int i=1;i<=15;i++){
                System.out.println(Thread.currentThread().getName()+ "  "+i);
            }
            //修改flag
            number=1;
            c1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
public class ConditionDemo {
    public static void main(String[] args) {
        ShareData shareData = new ShareData();

        new Thread(() -> {shareData.print5();},"A").start();
        new Thread(() -> {shareData.print10();},"B").start();
        new Thread(() -> {shareData.print15();},"C").start();
    }
}
