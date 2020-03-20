package com.atguigu.juc;

@FunctionalInterface
interface Foo{
//    public void sayHello();
    int add(int x,int y);

    default int mul(int x,int y){
        return x*y;
    }
    static int div(int x,int y){
        return  x/y;
    }
}

/**
 * 函数式接口中可以定义 default，static 的方法
 * lambda : 拷贝小括号，写死右箭头，落地大括号
 * @FunctionalInterface 显示声明函数式接口
 */
public class LambdaExpressDemo02 {
    public static void main(String[] args) {

//        Foo foo = () -> {
//            System.out.println("hello lambda");
//        };
//        foo.sayHello();

        Foo foo = (int x,int y) -> {
            System.out.println("add method");
            return x+y;
        };
        System.out.println(foo.add(6 ,6));
        System.out.println(foo.mul(6, 7));
        System.out.println(Foo.div(6, 2));
    }
}
