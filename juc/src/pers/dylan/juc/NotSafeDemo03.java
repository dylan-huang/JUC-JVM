package pers.dylan.juc;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;


/**
 * 线程不安全：
 * 1。故障现象：Exception in thread "0" java.util.ConcurrentModificationException  并发修改异常
 * 2。导致原因
 * 3。解决方法
 * 3。1 new Vector<>();
 * 3.2 Collections.synchronizedList(new ArrayList<>());
 * 3.3 new CopyOnWriteArrayList();
 * CopyOnWrite容器是写时复制的容器，往容器中添加内容时，不直接往当前容器的Object[] 中添加，而是先将当前的Object[]进行copy，
 * 复制出一个新的容器Object[] newElements，然后在新的容器中添加元素，添加完成后将原容器的引用指向新的容器，setArray(newElements)，
 * 好处：可以对CopyOnWrite容器进行并发的读，而不需要加锁，因为当前容器不会添加新的元素，所以CopyOnWrite也是一种读写分离的思想，读和写不同的容器
 */
public class NotSafeDemo03 {

    public static void main(String[] args) {

    }

    public static void listNotSafe() {
        List<String> list = new CopyOnWriteArrayList();  //写时复制
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, String.valueOf(i).toString()).start();
        }
    }
    public static void setNotSafe() {
        Set set = new CopyOnWriteArraySet();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(set);
            }, String.valueOf(i).toString()).start();
        }
    }
    public static void mapNotSafe() {
        Map<String,String> map = new ConcurrentHashMap<>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName().toString(),UUID.randomUUID().toString().substring(0, 8));
                System.out.println(map);
            }, String.valueOf(i).toString()).start();
        }
    }
}
