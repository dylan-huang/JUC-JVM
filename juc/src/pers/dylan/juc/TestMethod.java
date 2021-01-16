package pers.dylan.juc;
//
//import java.util.concurrent.TimeUnit;
//
//public class TestMethod {
//    public static void main(String[] args) {
//        Thread a = new Thread(() -> {
//            testLock();
//        }, "A");
//        Thread b = new Thread(() -> {
//            testLock();
//        }, "B");
//
//        a.start();
//        b.start();
//        System.out.println("A"+a.getState());
//        System.out.println("B"+b.getState());
//    }
//
//    public static synchronized void testLock(){
//        try {
//            TimeUnit.SECONDS.sleep(2);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//}

import java.util.concurrent.TimeUnit;

public class TestMethod {
    private class A extends Thread {
        @Override
        public void run() {
            System.out.println("A");
        }
    }

    private class B extends Thread {

        private A a;

        B(A a) {
            this.a = a;
        }

        @Override
        public void run() {
            try {
                a.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("B");
        }
    }

    public void test() {
        A a = new A();
        B b = new B(a);
        b.start();
//        try {
//            TimeUnit.SECONDS.sleep(2);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        a.start();
    }

    public static void main(String[] args) {
        TestMethod example = new TestMethod();
        example.test();
    }
}