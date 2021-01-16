package pers.dylan.juc;

import java.util.concurrent.locks.StampedLock;

public class TestStampedLock {

    public static void main(String[] args) {
        int i = new Point().distanceFromOrigin();
        System.out.println(i);
    }
}

class Point {
    private int x=3, y=4;
    StampedLock sl = new StampedLock();


    int distanceFromOrigin() {
        //乐观读
        final long stamp = sl.tryOptimisticRead();
        int curX = x, curY = y;
        // 判断执行读操作期间，
        // 是否存在写操作，如果存在，
        // 则 sl.validate 返回 false
        if (!sl.validate(stamp)) {
            //升级为悲观读锁
            long readLock = sl.readLock();
            try {
                curX = x;
                curY = y;
            } finally {
                sl.unlockRead(readLock);
            }
        }
        return curX*curX  + curY*curY;
    }
}