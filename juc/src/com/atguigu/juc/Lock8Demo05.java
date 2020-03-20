package com.atguigu.juc;


import java.util.concurrent.TimeUnit;

/**
 * 8 lock
 * 1。标准访问，先打印邮件还是短信
 * 2。邮件暂停4second，先打印哪个
 * 3。新增普通方法sayHello，先打印哪个
 * 4。两部手机，先打印邮件还是短信
 * 5。两个静态同步方法，一部手机，先打印邮件还是短信
 * 6。两个静态同步方法，两部手机，先打印邮件还是短信
 * 7。一个静态同步方法，一个普通同步方法，一部手机，先打印邮件还是短信
 * 8。一个静态同步方法，一个普通同步方法，两部手机，先打印邮件还是短信
 *
 * 一个对象中如果有多个synchronized方法，一个时刻内，只要一个线程去调用其中一个synchronized方法了，
 * 其他的线程都只能等待，换句话说，某一个时刻内，只能有一个线程去访问synchronizedf方法。
 *
 * 锁的是当前对象this，被锁定后，其他的线程都不能进入到当前对象的synchronized方法
 *
 * 3。加普通方法后和同步锁无关
 * 4。不是同一个对象，不是同一把锁
 *
 * 5-6：static锁的是全局锁
 * synchronized实现同步的基础，java中每一个对象都可以作为锁
 * 具体表现为以下三种形式：
 * 对于普通方法，锁的是当前对象实例
 * 对于同步方法块，锁是synchronized括号里配置的对象
 * 对于静态同步方法，锁是当前类的Class对象
 *
 * 当一个线程试图访问同步代码块时，它必须首先得到锁，退出或者抛出异常时释放锁
 *
 * 也就是说如果一个实例对象的非静态同步对象获得锁后，该实例对象的其他非静态同步方法必须等待获得锁的对象释放锁后才能获得锁
 * 可是别的实例对象的非静态同步方法跟该实例对象的非静态同步方法用的是不同的锁
 * 所以毋需等待该实例对象以获取锁的非静态同步方法释放锁就可以获取他们自己的锁
 *
 * 所有的静态同步方法用的也是同一把锁，Class对象本身
 * 这两把锁是两个不同的对象，所以静态同步方法和非静态同步方法之前是不会有竞态条件的。
 * 但是一旦一个静态同步方法获取锁后，其他静态方法必须要等待该方法释放锁后才能获取锁
 * 而不管是同一个实例对象的静态同步方法之间，还是不同实例对象的静态同步方法之间，只要他们同一个类的实例对象
 */

class Phone{
    public static synchronized void sendEmail() throws Exception{
        TimeUnit.SECONDS.sleep(4);
        System.out.println("===========sendEmail");
    }
    public static synchronized void sendSMS() throws Exception{
        System.out.println("===========sendSMS");
    }
    public void sayHello() throws Exception{
        System.out.println("hello");
    }
}

public class Lock8Demo05 {
    public static void main(String[] args)throws InterruptedException{
        Phone phone = new Phone();
        Phone phone1 = new Phone();

        new Thread(() -> {
            try {
                phone.sendEmail();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"A").start();

        TimeUnit.SECONDS.sleep(1);
        new Thread(() -> {
            try {
//                phone.sendSMS();
//                phone.sayHello();
                phone1.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"B").start();
    }
}
