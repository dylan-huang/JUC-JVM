package pers.dylan.single;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

//懒汉式
public class Lazy {

    private static boolean dylan =false;
    private Lazy() {
        synchronized (Lazy.class){
            if(dylan==false){
                dylan=true;
            }else {
                throw new RuntimeException("不要试图用反射破坏异常");
            }
        }
    }

    private volatile static Lazy lazy;

    //双重检测锁模式的 懒汉式模式 DCL模式
    public static Lazy getInstance(){
        if (lazy==null){
            synchronized (Lazy.class){
                if (lazy==null){  //不是一个原子性操作
                    lazy = new Lazy();
                    /*
                    1、分配内存空间
                    2、执行构造方法，初始化对象
                    3、将对象指向这个空间

                    真实可能执行顺序变化 123 -> 132

                    此时可能没有完成构造，造成指令重排，所以要加volatile
                     */
                }
            }
        }
        return lazy;
    }

    //多线程并发
   /* public static void main(String[] args) {
        for (int i=0;i<10;i++){
            new Thread(() ->{
                Lazy.getInstance();
            }).start();
        }
    }*/

    //反射
    public static void main(String[] args) throws Exception {
//        Lazy lazy= Lazy.getInstance();
        Field dylan = Lazy.class.getDeclaredField("dylan");
        dylan.setAccessible(true);

        Constructor<Lazy> declaredConstructor = Lazy.class.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        Lazy instance = declaredConstructor.newInstance();
        dylan.set(instance,false);
        Lazy instance1 = declaredConstructor.newInstance();
//        System.out.println(lazy.hashCode());
        System.out.println(instance.hashCode());
        System.out.println(instance1.hashCode());
    }
}
