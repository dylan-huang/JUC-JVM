package com.atguigu.juc;



import java.util.concurrent.TimeUnit;

/**
 * volatile:多个线程访问共享数据时，彼此的数据是可见的
 *  相较于synchronized 是一种较为轻量级的同步策略
 *
 * 注意：
 *  volatile 不具备互斥性
 *  volatile不能保证变量的原子性
 */
public class TestVolatile{
    public static void main(String[] args) throws InterruptedException {

       ThreadDemo td = new ThreadDemo();
       new Thread(td).start();

       while(true){
           if(td.isFlag()){
               System.out.println("===============");
               break;
           }
       }
    }
}

class ThreadDemo implements Runnable{
    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    private volatile boolean flag= false;

    @Override
    public void run() {


        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println("flag" + flag);

    }
}