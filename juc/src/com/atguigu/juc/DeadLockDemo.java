package com.atguigu.juc;

import java.util.concurrent.TimeUnit;

public class DeadLockDemo {

    public static Object resource1 = new Object();
    public static Object resource2 = new Object();
    public static void main(String[] args) {

        new Thread(()->{
            synchronized (resource1){
                System.out.println(Thread.currentThread()+"get resource1");
                try {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread()+"wait get resource2");
                synchronized (resource2){
                    System.out.println(Thread.currentThread()+"get resource2");
                }
            }
        },"resource1").start();

        new Thread(()->{
            synchronized (resource2){
                try {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread()+"wait get resource1");
                synchronized (resource1){
                    System.out.println(Thread.currentThread()+"get resource1");
                }
            }
        },"resource2").start();
    }
}
