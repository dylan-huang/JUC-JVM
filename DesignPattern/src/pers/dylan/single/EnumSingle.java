package pers.dylan.single;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

// enum 本身也是一个class

// enum中没有无参构造，只有有参构造
public enum EnumSingle {

    INSTANCE;

    private EnumSingle getInstance(){
        return INSTANCE;
    }
}

class Test{
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        EnumSingle instance1 = EnumSingle.INSTANCE;

//        Exception in thread "main" java.lang.NoSuchMethodException: pers.dylan.single.EnumSingle.<init>()
//        需要用jad 来反编译，javap -p 看不出效果
//        Constructor<EnumSingle> declaredConstructor = EnumSingle.class.getDeclaredConstructor(null);

//        Exception in thread "main" java.lang.IllegalArgumentException: Cannot reflectively create enum objects
        Constructor<EnumSingle> declaredConstructor = EnumSingle.class.getDeclaredConstructor(String.class,int.class);
        declaredConstructor.setAccessible(true);
        EnumSingle instance2 = declaredConstructor.newInstance();

        System.out.println(instance1);
        System.out.println(instance2);
    }
}