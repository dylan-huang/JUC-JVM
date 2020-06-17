package pers.dylan.juc;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 两个线程，操作初始值为0的一个变量
 * 一个线程进行+1 ，一个线程进行-1
 * <p>
 * 实现交替10轮，初始值为0
 *
 * 线程操作资源类
 * 判读/干活/通知
 * 防止虚假唤醒， 多线程横向通信和互访调用，通知必须用while
 */
public class ProdConsumerDemo04 {
    public static void main(String[] args) {
        AirCondition airCondition = new AirCondition();

        new Thread(() -> { for (int i = 0; i < 10; i++) { try { airCondition.increament(); } catch (Exception e) { e.printStackTrace(); } } }, "A").start();
        new Thread(() -> { for (int i = 0; i < 10; i++) { try { airCondition.increament(); } catch (Exception e) { e.printStackTrace(); } } }, "B").start();
        new Thread(() -> { for (int i = 0; i < 10; i++) { try { airCondition.decreament(); } catch (Exception e) { e.printStackTrace(); } } }, "C").start();
        new Thread(() -> { for (int i = 0; i < 10; i++) { try { airCondition.decreament(); } catch (Exception e) { e.printStackTrace(); } } }, "D").start();
    }
}


class AirCondition {
    private int number = 0;
    private Lock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();
    public void increament() throws Exception {
        lock.lock();
        try {
            while (0 != number) {
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName() + "   "+number);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
    public void decreament() throws Exception {
        lock.lock();
        try {
            while (0 == number) {
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName() + "   "+number);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

   /* public synchronized void increament() throws Exception {

        while (0 != number) {
            this.wait();
        }
        number++;
        System.out.println(Thread.currentThread().getName() + "   "+number);
        this.notifyAll();
    }

    public synchronized void decreament() throws Exception {

        while (0 == number) {
            this.wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName() + "   "+number);
        this.notifyAll();

    }*/
}