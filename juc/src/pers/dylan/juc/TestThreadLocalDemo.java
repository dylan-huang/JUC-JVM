package pers.dylan.juc;

import java.text.SimpleDateFormat;

public class TestThreadLocalDemo implements Runnable{

    private static final ThreadLocal<SimpleDateFormat> FORMAT_THREAD_LOCAL =
            ThreadLocal.withInitial(()-> new SimpleDateFormat("yyyy-MM-dd HH-mm-ss"));
    @Override
    public void run() {

    }
}
